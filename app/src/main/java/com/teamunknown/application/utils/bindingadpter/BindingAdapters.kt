package com.teamunknown.application.utils.bindingadpter

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.teamunknown.application.R
import com.teamunknown.application.utils.TimeUtil
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime


@BindingAdapter("isInvisible")
fun bindIsInvisible(view: View, isInvisible: Boolean?) {
    if (isInvisible == null || isInvisible) {
        view.visibility = View.INVISIBLE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        if (!isValidContextForGlide(view.context)) return

        Glide.with(view.context)
            .load(imageUrl)
            .thumbnail(0.3f)
            .placeholder(R.color.white)
            .into(view)
    }
}

@BindingAdapter("startDate", "endDate")
fun dateParse(view: TextView, startDate: String?, endDate: String?) {
    if (startDate == null || endDate == null) {
        view.text = ""
        return
    } else {
        val startDatePatten = "yyyy.MM.dd"
        val startZonedDateTime = ZonedDateTime.parse(startDate).withZoneSameInstant(ZoneId.systemDefault())
        val endZonedDateTime = ZonedDateTime.parse(endDate).withZoneSameInstant(ZoneId.systemDefault())

        view.text = if (startZonedDateTime.year == endZonedDateTime.year) {
            val endDatePatten = "MM.dd"
            view.resources.getString(
                R.string.travel_date_range,
                TimeUtil.getDateTimeFormatString(startZonedDateTime, startDatePatten),
                TimeUtil.getDateTimeFormatString(endZonedDateTime, endDatePatten)
            )
        } else {
            val endDatePatten = "yyyy.MM.dd"
            view.resources.getString(
                R.string.travel_date_range,
                TimeUtil.getDateTimeFormatString(startZonedDateTime, startDatePatten),
                TimeUtil.getDateTimeFormatString(endZonedDateTime, endDatePatten)
            )
        }
    }

}

private fun isValidContextForGlide(context: Context): Boolean {
    if (context is Activity) {
        return !context.isFinishing
    }
    return true
}
