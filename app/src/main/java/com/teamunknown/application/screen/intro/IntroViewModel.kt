package com.teamunknown.application.screen.intro

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamunknown.application.R
import com.teamunknown.application.utils.Event
import com.teamunknown.application.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val networkState: NetworkState
) : ViewModel() {

    private val _navigateToDetail = MutableLiveData<Event<Unit>>()
    val navigateToDetail: LiveData<Event<Unit>>
        get() = _navigateToDetail

    private val _dialogError = MutableLiveData<Event<@StringRes Int>>()
    val dialogError: LiveData<Event<Int>>
        get() = _dialogError

    fun navigateToMain() {
        if (!networkState.hasNetworkConnection()) {
            _dialogError.value = Event(R.string.network_error)
        } else {
            _navigateToDetail.value = Event(Unit)
        }
    }
}