package org.pbreakers.mobile.marvelheros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.pbreakers.mobile.marvelheros.model.MarvelCharacter
import org.pbreakers.mobile.marvelheros.views.common.ItemAdapter
import org.pbreakers.mobile.marvelheros.views.main.CharacterItemAdapter
import org.pbreakers.mobile.marvelheros.views.main.MainListAdapter

class MainActivity : AppCompatActivity() {

    private val characters = listOf(
        MarvelCharacter("Eric Ampire", "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ma/imac/refurb/imac-refurb-about-201810?wid=492&hei=429&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1541530952135"),
        MarvelCharacter("Bigomokero Ampire", "url")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_main)

        val categoryItemCharacter = characters.map(::CharacterItemAdapter)
        recyclerView.adapter = MainListAdapter(categoryItemCharacter as List<ItemAdapter<RecyclerView.ViewHolder>>)
    }
}
