package com.teamunknown.application.screen.main.checklist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamunknown.application.R
import com.teamunknown.application.databinding.CellTravelCheckListBinding
import com.teamunknown.application.model.CheckList
import com.teamunknown.application.utils.extensions.executeAfter
import timber.log.Timber

class TravelCheckListAdapter(private val travelCheckListViewModel: TravelCheckListViewModel, private val lifecycle: LifecycleOwner): ListAdapter<CheckList, TravelCheckListAdapter.ReviewViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CellTravelCheckListBinding>(layoutInflater, R.layout.cell_travel_check_list, parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ReviewViewHolder(
        private val binding: CellTravelCheckListBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CheckList) {
            binding.executeAfter {
                viewModel = travelCheckListViewModel
                lifecycleOwner = lifecycle
                checkList = item

                cbChecklist.setOnClickListener {
                    Timber.d("isCheckable: ${binding.cbChecklist.isChecked}")
                    if(binding.cbChecklist.isChecked) {
                        tvChecklist.paintFlags = binding.tvChecklist.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    }
                    else {
                        tvChecklist.paintFlags = 0
                    }
                    Timber.d("Before: ${item.isCheckable}")
                    val updateCheckList = item.copy(
                        isCheckable = binding.cbChecklist.isChecked
                    )
                    updateCheckList(updateCheckList.isCheckable)
                    Timber.d("After: ${updateCheckList.isCheckable}")
                    travelCheckListViewModel.updateCheckList(updateCheckList)
                }
                btnRemoveChecklist.setOnClickListener {
                    travelCheckListViewModel.removeCheckList(item)
                }
            }
        }

        private fun updateCheckList(checkable: Boolean) = with(binding) {
           cbChecklist.isChecked = checkable
        }
    }


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CheckList>() {

            override fun areItemsTheSame(oldItem: CheckList, newItem: CheckList): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem:CheckList, newItem: CheckList): Boolean =
                oldItem == newItem
        }
    }
}