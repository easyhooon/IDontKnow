package com.teamunknown.application.screen.intro

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.teamunknown.application.R
import com.teamunknown.application.databinding.ActivityIntroBinding
import com.teamunknown.application.DataBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : DataBindingActivity<ActivityIntroBinding>(R.layout.activity_intro) {

    private val navController: NavController?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController?.setGraph(R.navigation.nav_intro, intent.extras)
    }
}