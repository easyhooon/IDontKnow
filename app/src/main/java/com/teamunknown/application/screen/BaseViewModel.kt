package com.teamunknown.application.screen

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamunknown.application.utils.Event

open class BaseViewModel : ViewModel() {

    protected val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    protected val _error = MutableLiveData<Event<@StringRes Int>>()
    val error: LiveData<Event<Int>> = _error
}