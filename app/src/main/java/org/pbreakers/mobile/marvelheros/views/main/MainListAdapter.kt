package org.pbreakers.mobile.marvelheros.views.main

import org.pbreakers.mobile.marvelheros.views.common.AnyItemAdapter
import org.pbreakers.mobile.marvelheros.views.common.RecyclerListAdapter

class MainListAdapter(var data: List<AnyItemAdapter>) : RecyclerListAdapter(data) {
    fun add(item: AnyItemAdapter) {
        data += item
        val index = data.indexOf(item)

        if (index == -1) return
        notifyItemInserted(index)
    }

    fun delete(item: AnyItemAdapter) {
        val index = data.indexOf(item)

        if (index == -1) return
        data -= item
        notifyItemRemoved(index)
    }
}