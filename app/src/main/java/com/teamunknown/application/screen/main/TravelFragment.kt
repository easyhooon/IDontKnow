package com.teamunknown.application.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
import com.teamunknown.application.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import com.teamunknown.application.R
import com.teamunknown.application.databinding.FragmentTravelBinding
import com.teamunknown.application.screen.main.record.TravelRecordFragment
import com.teamunknown.application.screen.main.setting.TravelSettingFragment
import com.teamunknown.application.utils.extensions.toPx


@AndroidEntryPoint
class TravelFragment : DataBindingFragment<FragmentTravelBinding>(R.layout.fragment_travel) {

    private val iconArray = listOf(R.drawable.icon_airport, R.drawable.icon_setting)
    private val titleArray = listOf(R.string.travel_tab_record, R.string.travel_tab_setting)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        with(dataBinding) {
            vpTravel.apply {
                adapter = TravelAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
                setPageTransformer(MarginPageTransformer(8.toPx(requireContext())))
            }

            TabLayoutMediator(tabTravel, vpTravel) { tab, position ->
                tab.apply {
                    setIcon(iconArray[position])
                    setText(titleArray[position])
                }
            }.attach()
        }
    }

    inner class TravelAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
        override fun getItemCount(): Int = TAB_PAGES.size
        override fun createFragment(position: Int): Fragment = TAB_PAGES[position]()
    }

    companion object {
        private val TAB_PAGES = arrayOf(
            { TravelRecordFragment() },
            { TravelSettingFragment() }
        )
    }
}