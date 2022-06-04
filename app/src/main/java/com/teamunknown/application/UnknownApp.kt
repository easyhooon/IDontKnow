package com.teamunknown.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.ResourcesCompat
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import es.dmoral.toasty.Toasty
import timber.log.Timber

@HiltAndroidApp
class UnknownApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initToasty()
        initTimber()
    }

    private fun initToasty() {
        Toasty.Config.getInstance()
            .setTextSize(14)
            .apply {
                ResourcesCompat.getFont(this@UnknownApp, R.font.font_demi_light)?.let {
                    setToastTypeface(it)
                }
            }
            .apply()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}