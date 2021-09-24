package com.example.tarot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.tarot.model.TarotImage
import java.util.ArrayList
import java.util.concurrent.TimeoutException
import android.view.WindowManager





class CardsDetails : AppCompatActivity() {

    private var filterData = mutableListOf<TarotImage>()
    private lateinit var data: List<TarotImage>

    private lateinit var tvFirstName: TextView
    private lateinit var tvSecondName: TextView
    private lateinit var tvThirdName: TextView
    private lateinit var tvCardName: TextView
    private lateinit var tvSecondCardName: TextView
    private lateinit var tvThirdCardName: TextView

    private lateinit var ivFirst: ImageView
    private lateinit var ivSecond: ImageView
    private lateinit var ivThird: ImageView


    private lateinit var ivCard: ImageView
    private lateinit var ivCardSecond: ImageView
    private lateinit var ivCardThird: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_details)

        tvFirstName = findViewById(R.id.tvFirstName)
        tvSecondName = findViewById(R.id.tvSecondName)
        tvThirdName = findViewById(R.id.tvThirdName)

        ivCard = findViewById(R.id.ivCard)
        ivCardSecond = findViewById(R.id.ivCard2)
        ivCardThird = findViewById(R.id.ivCard3)

        tvCardName = findViewById(R.id.tvCardName)
        tvSecondCardName = findViewById(R.id.tvSecondCardName)
        tvThirdCardName = findViewById(R.id.tvThirdCardName)

        ivFirst = findViewById(R.id.ivCardFirst)
        ivSecond = findViewById(R.id.ivCardSecond)
        ivThird = findViewById(R.id.ivCardThird)

        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.WHITE

        filterData(intent.getStringArrayListExtra("strings"))
        renderData()
    }

    private fun filterData(myStrings: ArrayList<String>?) {
        myStrings?.forEach { id ->
            data = Data.getData().filter { it.cardId.toString() == id }
            filterData.add(data[0])
        }
    }

    private fun renderData() {
        tvFirstName.text = filterData[0].description
        tvSecondName.text = filterData[1].description
        tvThirdName.text = filterData[2].description
        ivCard.setImageResource(filterData[0].route)
        ivCardSecond.setImageResource(filterData[1].route)
        ivCardThird.setImageResource(filterData[2].route)
        tvCardName.text = filterData[0].description
        tvSecondCardName.text = filterData[1].description
        tvThirdCardName.text = filterData[2].description
        ivFirst.setImageResource(filterData[0].route)
        ivSecond.setImageResource(filterData[1].route)
        ivThird.setImageResource(filterData[2].route)
    }
}