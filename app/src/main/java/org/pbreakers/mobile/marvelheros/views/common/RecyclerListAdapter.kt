package org.pbreakers.mobile.marvelheros.views.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class RecyclerListAdapter(val items: List<AnyItemAdapter>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    final override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(layoutId, parent, false)

        return items.first { it.layoutId == layoutId }.onCreateViewHolder(view)
    }

    final override fun getItemViewType(position: Int): Int = items[position].layoutId

    final override fun getItemCount(): Int = items.size

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].bindViewHolder(holder)
    }

}

typealias AnyItemAdapter = ItemAdapter<RecyclerView.ViewHolder>