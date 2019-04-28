package org.pbreakers.mobile.marvelheros.views.main

import androidx.recyclerview.widget.RecyclerView
import org.pbreakers.mobile.marvelheros.views.common.ItemAdapter
import org.pbreakers.mobile.marvelheros.views.common.RecyclerListAdapter

class MainListAdapter(var data: List<ItemAdapter<RecyclerView.ViewHolder>>) : RecyclerListAdapter(data) {
    fun add(item: ItemAdapter<RecyclerView.ViewHolder>) {
        data += item
        val index = data.indexOf(item)

        if (index == -1) return
        notifyItemInserted(index)
    }

    fun delete(item: ItemAdapter<RecyclerView.ViewHolder>) {
        val index = data.indexOf(item)

        if (index == -1) return
        data -= item
        notifyItemRemoved(index)
    }
}