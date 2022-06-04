package com.teamunknown.application.screen.main.record

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.teamunknown.application.R
import com.teamunknown.application.model.Travel
import com.teamunknown.application.screen.BaseViewModel
import com.teamunknown.application.usecase.travel.GetTravelRecordsUseCase
import com.teamunknown.application.utils.Event
import com.teamunknown.application.utils.Result
import com.teamunknown.application.utils.isLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelRecordViewModel @Inject constructor(
    private val getTravelRecordsUseCase: GetTravelRecordsUseCase
) : BaseViewModel() {

    // Expended Position
    private var _previousExpandedPosition = RecyclerView.NO_POSITION
    val previousExpandedPosition
        get() = _previousExpandedPosition

    // Previous Expended Position
    private var _expandedPosition = RecyclerView.NO_POSITION
    val expandedPosition
        get() = _expandedPosition

    private val _travelList = MutableStateFlow<List<Travel>>(emptyList())
    val travelList: StateFlow<List<Travel>> = _travelList

    private val _navigateToCreateTravel = MutableLiveData<Event<Unit>>()
    val navigateToCreateTravel: LiveData<Event<Unit>>
        get() = _navigateToCreateTravel

    init {
        getTravelList()
    }

    private fun getTravelList() {
        viewModelScope.launch {
            launch {
                getTravelRecordsUseCase(Unit).onEach {
                    _loading.value = it.isLoading
                }.collect {
                    when (it) {
                        is Result.Loading -> return@collect
                        is Result.Success -> {
                            _travelList.value = it.data
                        }
                        is Result.Error -> {
                            Timber.e("error ${it.exception}")
                            _error.value = Event(R.string.all_error)
                        }
                    }
                }
            }
        }
    }

    fun setExpandedPosition(position: Int) {
        _expandedPosition = position
    }

    fun setPreviousExpandedPosition(position: Int) {
        _previousExpandedPosition = position
    }

    fun navigateToCreateTravel() {
        _navigateToCreateTravel.value = Event(Unit)
    }
}