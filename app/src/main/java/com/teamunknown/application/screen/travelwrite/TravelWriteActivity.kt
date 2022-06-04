package com.teamunknown.application.screen.travelwrite

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.teamunknown.application.DataBindingActivity
import com.teamunknown.application.R
import com.teamunknown.application.databinding.ActivityTravelWriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelWriteActivity : DataBindingActivity<ActivityTravelWriteBinding>(R.layout.activity_travel_write) {

    private val navController: NavController
        get() = findNavController(R.id.nav_write)

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}