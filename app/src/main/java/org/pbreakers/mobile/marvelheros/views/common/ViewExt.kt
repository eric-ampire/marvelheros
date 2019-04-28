package org.pbreakers.mobile.marvelheros.views.common

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun<T : View> RecyclerView.ViewHolder.bindView(viewId: Int): Lazy<T> {
    return lazy {
        itemView.findViewById<T>(viewId)
    }
}

fun ImageView.loadImage(photoUrl: String) {
    Glide.with(context).load(photoUrl).into(this)
}