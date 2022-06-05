package com.teamunknown.application.screen.main.checklist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamunknown.application.model.CheckList
import com.teamunknown.application.usecase.checklist.CheckListRepository
import com.teamunknown.application.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelCheckListViewModel @Inject constructor(
    private val checkListRepository: CheckListRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val travelId = savedStateHandle.get<Long>(TRAVEL_ID)?: 0

    val registerCheckListText = MutableStateFlow<String>("")

    val isEditable = MutableStateFlow<Boolean>(false)

    init {
        Timber.d("travelId: $travelId")
    }

    val checkList: StateFlow<Result<List<CheckList>>> = checkListRepository.getCheckList(travelId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = Result.Loading
        )

    fun changeEditable() {
        isEditable.value = !isEditable.value
    }

    fun registerCheckList() = viewModelScope.launch {
        checkListRepository.registerCheckList(
            CheckList(
                travelId = travelId,
                checkItem = registerCheckListText.value,
                isCheckable = false
            )
        )
        clearCheckListText()
    }


    private fun clearCheckListText() {
        Timber.tag("checklistText").d(registerCheckListText.value)
        registerCheckListText.value = ""
    }

    fun removeCheckList(checkList: CheckList) = viewModelScope.launch {
        checkListRepository.clearCheckList(checkList)
    }

    fun removeAllCheckList() = viewModelScope.launch {
        checkListRepository.clearCheckList()
    }

    fun updateCheckList(checkList: CheckList) = viewModelScope.launch {
        checkListRepository.updateCheckList(checkList)
    }

    companion object {
        private const val TRAVEL_ID = "travelItem"
    }
}