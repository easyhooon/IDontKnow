package com.teamunknown.application.screen.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.teamunknown.application.DataBindingFragment
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentIntroBinding
import com.teamunknown.application.utils.EventObserver
import com.teamunknown.application.utils.extensions.safeNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : DataBindingFragment<FragmentIntroBinding>(R.layout.fragment_intro) {

    private val introViewModel: IntroViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView() {
        introViewModel.navigateToMain()
    }

    private fun initObserver() {
        introViewModel.navigateToDetail.observe(viewLifecycleOwner, EventObserver {
            activity?.run {
                findNavController().safeNavigate(IntroFragmentDirections.actionIntroFragmentToMainActivity())
                finish()
            }
        })
    }
}