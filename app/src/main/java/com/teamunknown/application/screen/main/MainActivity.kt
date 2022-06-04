package com.teamunknown.application.screen.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.teamunknown.application.R
import com.teamunknown.application.databinding.ActivityMainBinding
import com.teamunknown.application.DataBindingActivity
import com.teamunknown.application.utils.BackPressCloseManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var backPressCloseManager: BackPressCloseManager

    private val navController: NavController
        get() = findNavController(R.id.nav_main)

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backPressCloseManager = BackPressCloseManager(this@MainActivity)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

    override fun onBackPressed() {
        currentNavController?.value.let {
            if (it?.graph?.startDestinationId == it?.currentDestination?.id) {
                backPressCloseManager.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }
}