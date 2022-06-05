package com.teamunknown.application.screen.main.checklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentTravelCheckListBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TravelCheckListFragment : DataBindingFragment<FragmentTravelCheckListBinding>(R.layout.fragment_travel_check_list) {

    private val travelCheckListviewModel: TravelCheckListViewModel by viewModels()

    private val adapter: TravelCheckListAdapter by lazy { TravelCheckListAdapter(travelCheckListviewModel, viewLifecycleOwner)}

    lateinit var travelId: Number

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
    }

    private fun initView() {
        Timber.d("arguments: $arguments")
        arguments?.apply {
            travelId = getLong("travelItem")
            Timber.d("$travelId")
        }

        bind {
            viewModel = travelCheckListviewModel
            travelCheckListAdapter = adapter
            lifecycleOwner = viewLifecycleOwner
        }
    }

    private fun initListener() = with(dataBinding) {
        tbChecklist.setOnClickListener{
            if(!findNavController().navigateUp())
                requireActivity().finish()
            else
                findNavController().navigateUp()
        }
    }
}