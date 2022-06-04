package com.teamunknown.application.screen.travelwrite

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentTravelWriteBinding
import com.teamunknown.application.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import org.threeten.bp.Instant

@AndroidEntryPoint
class TravelWriteFragment : DataBindingFragment<FragmentTravelWriteBinding>(R.layout.fragment_travel_write) {

    private val travelWriteViewModel: TravelWriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = travelWriteViewModel
        }

        initListener()
        initObserver()
    }

    private fun initListener() {
        with(dataBinding) {
            toolbar.apply {
                setNavigationOnClickListener {
                    if (!findNavController().navigateUp()) {
                        requireActivity().finish()
                    }
                }
            }

            etTravelTitle.addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun afterTextChanged(editable: Editable?) {}
                    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        travelWriteViewModel.setTravelTitle(text.toString())
                    }
                }
            )
        }
    }

    private fun initObserver() {
        travelWriteViewModel.error.observe(viewLifecycleOwner, EventObserver {
            Toasty.error(requireContext(), it).show()
        })

        travelWriteViewModel.navigateToStartDate.observe(viewLifecycleOwner, EventObserver {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    travelWriteViewModel.updateStartDate(year, month.plus(1), dayOfMonth)
                },
                1999,
                12,
                12
            ).apply {
                datePicker.minDate = travelWriteViewModel.endDateTime.value?.let {
                    it.toInstant().toEpochMilli()
                } ?: Instant.now().toEpochMilli()

                updateDate(it.year, it.monthValue.minus(1), it.dayOfMonth)
            }.show()
        })

        travelWriteViewModel.navigateToEndDate.observe(viewLifecycleOwner, EventObserver {
            DatePickerDialog(
                requireContext(),
                { _, year, month, dayOfMonth ->
                    travelWriteViewModel.updateEndDate(year, month.plus(1), dayOfMonth)
                },
                1999,
                12,
                12
            ).apply {
                datePicker.minDate = travelWriteViewModel.endDateTime.value?.let {
                    it.toInstant().toEpochMilli()
                } ?: Instant.now().toEpochMilli()

                travelWriteViewModel.startDateTime.value?.let {
                    datePicker.minDate = it.toInstant().toEpochMilli()
                }
                updateDate(it.year, it.monthValue.minus(1), it.dayOfMonth)
            }.show()
        })

        travelWriteViewModel.navigateToCancel.observe(viewLifecycleOwner, EventObserver {
            if (!findNavController().navigateUp()) {
                requireActivity().finish()
            } else {
                findNavController().navigateUp()
            }
        })
    }
}