package com.teamunknown.application.screen.main.record

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamunknown.application.R
import com.teamunknown.application.model.Travel
import com.teamunknown.application.screen.BaseViewModel
import com.teamunknown.application.usecase.travel.GetTravelRecordsUseCase
import com.teamunknown.application.utils.Event
import com.teamunknown.application.utils.Result
import com.teamunknown.application.utils.isLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelRecordViewModel @Inject constructor(
    private val getTravelRecordsUseCase: GetTravelRecordsUseCase
) : BaseViewModel() {

    private val _travelList = MutableStateFlow<List<Travel>>(emptyList())

    fun getTravelList(travelId: Long?) {
        viewModelScope.launch {
            launch {
                getTravelRecordsUseCase(
                    GetTravelRecordsUseCase.Params(travelId)
                ).onEach {
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
}