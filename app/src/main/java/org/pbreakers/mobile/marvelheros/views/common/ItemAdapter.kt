package org.pbreakers.mobile.marvelheros.views.common

import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class ItemAdapter<T: RecyclerView.ViewHolder>(@LayoutRes open val layoutId: Int) {

    abstract fun onCreateViewHolder(view: View): T

    abstract fun T.onBindViewHolder()

    @Suppress(names = ["UNCHECKED_CAST"])
    fun bindViewHolder(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as T).onBindViewHolder()
    }
}