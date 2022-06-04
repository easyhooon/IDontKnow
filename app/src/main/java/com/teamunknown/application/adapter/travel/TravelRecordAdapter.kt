package com.teamunknown.application.adapter.travel

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamunknown.application.R
import com.teamunknown.application.databinding.CellTravelRecordBinding
import com.teamunknown.application.model.ImageModel
import com.teamunknown.application.model.Travel
import com.teamunknown.application.screen.main.record.TravelRecordViewModel
import com.teamunknown.application.utils.extensions.executeAfter
import timber.log.Timber

class TravelRecordAdapter(
    private val adapterLifecycleOwner: LifecycleOwner,
    private val travelRecordViewModel: TravelRecordViewModel
) : ListAdapter<Travel, TravelRecordViewHolder>(
    object : DiffUtil.ItemCallback<Travel>() {
        override fun areItemsTheSame(oldItem: Travel, newItem: Travel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Travel, newItem: Travel): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelRecordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TravelRecordViewHolder(CellTravelRecordBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TravelRecordViewHolder, position: Int) {
        val wasExpanded = (position == travelRecordViewModel.expandedPosition)
        if (wasExpanded) travelRecordViewModel.setPreviousExpandedPosition(position)

        holder.binding.executeAfter {
            lifecycleOwner = adapterLifecycleOwner
            viewModel = travelRecordViewModel
            travel = getItem(position)
        }

        holder.itemView.setOnClickListener {
            val parent = holder.itemView.parent as? ViewGroup ?: return@setOnClickListener
            val expanded = holder.binding.isExpanded ?: false
            val transition = TransitionInflater.from(holder.itemView.context).inflateTransition(R.transition.expand_button)

            TransitionManager.beginDelayedTransition(parent, transition)

            notifyItemChanged(travelRecordViewModel.previousExpandedPosition)

            holder.binding.executeAfter {
                travelRecordViewModel.setExpandedPosition(if (!expanded) position else RecyclerView.NO_POSITION)
                travelRecordViewModel.setPreviousExpandedPosition(if (!expanded) position else RecyclerView.NO_POSITION)
                isExpanded = !expanded
            }
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.cell_travel_record
}