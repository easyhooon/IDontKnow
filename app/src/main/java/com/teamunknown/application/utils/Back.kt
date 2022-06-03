package com.teamunknown.application.utils

import android.app.Activity
import android.widget.Toast
import com.teamunknown.application.R
import es.dmoral.toasty.Toasty

class BackPressCloseManager(private val activity: Activity) {

    private var toasty: Toast? = null
    private var backKeyPressedTime: Long = 0L

    fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            showFinishToast()
            return
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish()
            toasty?.cancel()
        }
    }

    private fun showFinishToast() {
        toasty = Toasty.normal(activity, R.string.back_close, Toast.LENGTH_SHORT)
        toasty!!.show()
    }
}