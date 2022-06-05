package com.teamunknown.application.screen.main.checklist

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.teamunknown.application.DataBindingActivity
import com.teamunknown.application.R
import com.teamunknown.application.databinding.ActivityCheckListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelCheckListActivity :
    DataBindingActivity<ActivityCheckListBinding>(R.layout.activity_check_list) {

    private val navController: NavController?
        get() = supportFragmentManager.findFragmentById(R.id.nav_checklist_fragment)?.findNavController()

    override fun onSupportNavigateUp(): Boolean = navController?.navigateUp() ?: false
}