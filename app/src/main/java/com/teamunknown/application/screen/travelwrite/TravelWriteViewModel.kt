package com.teamunknown.application.screen.travelwrite

import androidx.lifecycle.*
import com.teamunknown.application.R
import com.teamunknown.application.model.Travel
import com.teamunknown.application.screen.BaseViewModel
import com.teamunknown.application.usecase.travel.SetTravelRecordsUseCase
import com.teamunknown.application.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.threeten.bp.ZonedDateTime
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelWriteViewModel @Inject constructor(
    private val setTravelRecordsUseCase: SetTravelRecordsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _travelTitle = savedStateHandle.getLiveData<String>(KEY_TRAVEL_TITLE, "")
    val travelTitle: LiveData<String>
        get() = _travelTitle

    private val _startDateTime = savedStateHandle.getLiveData<ZonedDateTime>(KEY_START_DATE_TIME)
    val startDateTime: LiveData<ZonedDateTime>
        get() = _startDateTime

    private val _endDateTime = savedStateHandle.getLiveData<ZonedDateTime>(KEY_END_DATE_TIME)
    val endDateTime: LiveData<ZonedDateTime>
        get() = _endDateTime

    private val _enabledInput = MediatorLiveData<Boolean>()
    val enabledInput: LiveData<Boolean>
        get() = _enabledInput

    private val _navigateToStartDate = MutableLiveData<Event<ZonedDateTime>>()
    val navigateToStartDate: LiveData<Event<ZonedDateTime>>
        get() = _navigateToStartDate

    private val _navigateToEndDate = MutableLiveData<Event<ZonedDateTime>>()
    val navigateToEndDate: LiveData<Event<ZonedDateTime>>
        get() = _navigateToEndDate

    private val _navigateToCancel = MutableLiveData<Event<Unit>>()
    val navigateToCancel: LiveData<Event<Unit>>
        get() = _navigateToCancel

    fun setTravelTitle(travelTitle: String?) {
        if (this.travelTitle.value == travelTitle || travelTitle == null) {
            return
        }

        savedStateHandle.set(KEY_TRAVEL_TITLE, travelTitle)
    }

    fun updateStartDate(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        if (startDateTime.value == null) {
            _startDateTime.value = ZonedDateTime.now()
        }
        startDateTime.value?.let {
            if (it.year == year && it.monthValue == monthOfYear && it.dayOfMonth == dayOfMonth) {
                return
            }
            savedStateHandle.set(KEY_START_DATE_TIME, it.withYear(year)?.withMonth(monthOfYear)?.withDayOfMonth(dayOfMonth))
        }
    }

    fun updateEndDate(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        if (endDateTime.value == null) {
            _endDateTime.value = ZonedDateTime.now()
        }

        endDateTime.value?.let {
            if (it.year == year && it.monthValue == monthOfYear && it.dayOfMonth == dayOfMonth) {
                return
            }
            savedStateHandle.set(KEY_END_DATE_TIME, it.withYear(year)?.withMonth(monthOfYear)?.withDayOfMonth(dayOfMonth))
        }
    }

    fun navigateToStartDate() {
        _navigateToStartDate.value = Event(startDateTime.value ?: ZonedDateTime.now())
    }

    fun navigateToEntDate() {
        _navigateToEndDate.value = Event(endDateTime.value ?: ZonedDateTime.now())
    }

    fun createTravel() {
        if (travelTitle.value.isNullOrBlank() || startDateTime.value == null || endDateTime.value == null) {
            _error.value = Event(R.string.travel_write_error)
        } else {
            setTravelRecord()
        }
    }

    private fun setTravelRecord() {
        viewModelScope.launch {
            launch {
                setTravelRecordsUseCase(
                    SetTravelRecordsUseCase.Params(
                        Travel(
                            travelId = System.currentTimeMillis(),
                            travelTitle = travelTitle.value!!,
                            startDate = startDateTime.value.toString(),
                            endDate = endDateTime.value.toString()
                        )
                    )
                )
            }
        }
    }

    companion object {
        private const val KEY_TRAVEL_TITLE = "KEY_TRAVEL_TITLE"
        private const val KEY_START_DATE_TIME = "START_DATE_TIME"
        private const val KEY_END_DATE_TIME = "END_DATE_TIME"
    }
}