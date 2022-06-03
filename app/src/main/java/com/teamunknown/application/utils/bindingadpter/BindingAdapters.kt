package com.teamunknown.application.utils.bindingadpter

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.teamunknown.application.R


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

private fun isValidContextForGlide(context: Context): Boolean {
    if (context is Activity) {
        return !context.isFinishing
    }
    return true
}
