package com.teamunknown.application.screen.main.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentTravelRecordBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class TravelRecordFragment : DataBindingFragment<FragmentTravelRecordBinding>(R.layout.fragment_travel_record) {

    private val travelRecordViewModel: TravelRecordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = travelRecordViewModel
        }

        initView()
        initListener()
        initObserver()
    }

    private fun initView() {
        travelRecordViewModel.getTravelList(0L)
    }

    private fun initListener() {

    }

    private fun initObserver() {

    }
}