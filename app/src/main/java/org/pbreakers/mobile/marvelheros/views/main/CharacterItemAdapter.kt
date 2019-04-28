package org.pbreakers.mobile.marvelheros.views.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.pbreakers.mobile.marvelheros.R
import org.pbreakers.mobile.marvelheros.model.MarvelCharacter
import org.pbreakers.mobile.marvelheros.views.common.ItemAdapter
import org.pbreakers.mobile.marvelheros.views.common.bindView
import org.pbreakers.mobile.marvelheros.views.common.loadImage

class CharacterItemAdapter(val character: MarvelCharacter): ItemAdapter<CharacterItemAdapter.ViewHolder>(R.layout.item_caractere) {
    override fun onCreateViewHolder(view: View): ViewHolder = ViewHolder(view)

    override fun ViewHolder.onBindViewHolder() {
        textView.text = character.name
        imageView.loadImage(character.imageUrl)
    }


    class ViewHolder(viewItem: View) :RecyclerView.ViewHolder(viewItem) {
        val textView by bindView<TextView>(R.id.textView)
        val imageView by bindView<ImageView>(R.id.imageView)
    }
}