package com.teamunknown.application.screen.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamunknown.application.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor() : ViewModel() {

    private val _navigateToDetail = MutableLiveData<Event<Unit>>()
    val navigateToDetail: LiveData<Event<Unit>>
        get() = _navigateToDetail

    fun navigateToMain() {
        viewModelScope.launch {
            delay(800L)
            _navigateToDetail.value = Event(Unit)
        }
    }
}