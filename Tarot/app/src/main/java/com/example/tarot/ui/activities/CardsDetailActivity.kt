package com.example.tarot.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.view.Window
import com.example.tarot.model.TarotImage
import java.util.ArrayList
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarot.Data
import com.example.tarot.R
import com.example.tarot.ui.adapter.CardDescriptionAdapter
import com.example.tarot.ui.adapter.CardImageAdapter


class CardsDetailActivity : AppCompatActivity() {

    private var filterData = mutableListOf<TarotImage>()
    private lateinit var data: List<TarotImage>

    private lateinit var rvCard: RecyclerView
    private lateinit var rvCardDetail: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_details)

        rvCard = findViewById(R.id.rvCardImage)
        rvCardDetail = findViewById(R.id.rvCardDetail)

        initToolbar()
        filterData(intent.getStringArrayListExtra("strings"))
        renderData()
    }

    private fun initToolbar() {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.WHITE
    }

    private fun filterData(myStrings: ArrayList<String>?) {
        myStrings?.forEach { id ->
            data = Data.getData().filter { it.cardId.toString() == id }
            filterData.add(data[0])
        }
    }

    private fun renderData() {
        rvCard.apply {
            adapter = CardImageAdapter(filterData)
        }
        rvCardDetail.apply {
            adapter = CardDescriptionAdapter(filterData)
        }
    }
}