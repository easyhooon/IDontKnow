package com.teamunknown.application.screen.main.setting

import android.os.Bundle
import android.view.View
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentTravelSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelSettingFragment : DataBindingFragment<FragmentTravelSettingBinding>(R.layout.fragment_travel_setting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}