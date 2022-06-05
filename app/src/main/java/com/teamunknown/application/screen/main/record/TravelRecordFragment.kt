package com.teamunknown.application.screen.main.record

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.adapter.travel.TravelRecordAdapter
import com.teamunknown.application.databinding.FragmentTravelRecordBinding
import com.teamunknown.application.screen.main.TravelFragmentDirections
import com.teamunknown.application.utils.EventObserver
import com.teamunknown.application.utils.extensions.launchAndRepeatWithViewLifecycle
import com.teamunknown.application.utils.extensions.safeNavigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class TravelRecordFragment : DataBindingFragment<FragmentTravelRecordBinding>(R.layout.fragment_travel_record) {

    private val travelRecordViewModel: TravelRecordViewModel by viewModels()

    private val travelRecordAdapter: TravelRecordAdapter by lazy {
        TravelRecordAdapter(viewLifecycleOwner, travelRecordViewModel)
    }

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
        with(dataBinding) {
            rvRecord.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = travelRecordAdapter
            }
        }
    }

    private fun initListener() {

    }

    private fun initObserver() {
        launchAndRepeatWithViewLifecycle {
            launch {
                travelRecordViewModel.travelList.collect {
                    travelRecordAdapter.submitList(it)
                }
            }
        }
        travelRecordViewModel.loading.observe(viewLifecycleOwner) {
            Timber.e("로그 $it")
        }
        travelRecordViewModel.navigateToCreateTravel.observe(viewLifecycleOwner, EventObserver {
            findNavController().safeNavigate(TravelFragmentDirections.actionTravelFragmentToTravelWriteActivity())
        })

        travelRecordViewModel.navigateToCheckList.observe(viewLifecycleOwner, EventObserver { travel ->
            findNavController().navigate(R.id.action_travelFragment_to_travelCheckListFragment, bundleOf(
                "travelItem" to travel.travelId
            ))
        })
    }

    override fun onDestroyView() {
        dataBinding.rvRecord.adapter = null
        super.onDestroyView()
    }
}