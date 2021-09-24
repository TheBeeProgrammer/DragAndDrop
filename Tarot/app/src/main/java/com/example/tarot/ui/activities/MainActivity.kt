package com.example.tarot.ui.activities

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.view.get
import com.example.tarot.Data
import com.example.tarot.MaskDragShadowBuilder
import com.example.tarot.R
import com.example.tarot.model.TarotImage
import com.google.android.material.card.MaterialCardView
import java.util.*


class MainActivity : AppCompatActivity() {

    private val cardDraggedMessage = "Card Dragged"

    private lateinit var cardViewFirst: MaterialCardView
    private lateinit var cardViewSecond: MaterialCardView
    private lateinit var cardViewThird: MaterialCardView

    private lateinit var textViewFirstName: TextView
    private lateinit var textViewSecondName: TextView
    private lateinit var textViewThirdName: TextView

    private lateinit var image: ImageView
    private lateinit var btnShowDetails: AppCompatButton
    private lateinit var tvTitleToolbar: TextView

    private var idList = arrayListOf<String>()

    private var data = Data.getData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        navigateToDetailsActivity()
        attachViewDragListener()


    }

    private fun initComponents() {
        tvTitleToolbar = findViewById(R.id.tvTitle)
        cardViewFirst = findViewById(R.id.cardView)
        cardViewSecond = findViewById(R.id.cardView2)
        cardViewThird = findViewById(R.id.cardView3)
        textViewFirstName = findViewById(R.id.tvFirstName)
        textViewSecondName = findViewById(R.id.tvSecondName)
        textViewThirdName = findViewById(R.id.tvThirdName)
        image = findViewById(R.id.card_icon)
        btnShowDetails = findViewById(R.id.btnShowDetails)
        cardViewFirst.setOnDragListener(maskDragListener)
    }

    private fun navigateToDetailsActivity() {
        btnShowDetails.setOnClickListener {
            val myIntent = Intent(this@MainActivity, CardsDetailActivity::class.java)
            myIntent.putExtra("strings", idList);
            this@MainActivity.startActivity(myIntent)
        }
    }

    private val maskDragListener = View.OnDragListener { view, dragEvent ->
        (view as? CardView)?.let {
            when (dragEvent.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    return@OnDragListener true
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    return@OnDragListener true
                }
                DragEvent.ACTION_DRAG_LOCATION -> {
                    return@OnDragListener true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    return@OnDragListener true
                }
                DragEvent.ACTION_DROP -> {
                    val model = data.shuffled()[0]
                    it.setBackgroundResource(model.route)
                    cardViewLogic(it.id, model)
                    return@OnDragListener true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    return@OnDragListener true
                }
                else -> return@OnDragListener false
            }
        }
        false
    }

    private fun cardViewLogic(resId: Int, model: TarotImage) {
        data = data.filter { it.cardId != model.cardId }
        idList.add(model.cardId.toString())
        when (resId) {
            R.id.cardView -> {
                textViewFirstName.text = model.name
                cardViewSecond.setOnDragListener(maskDragListener)
                cardViewSecond.strokeColor = Color.parseColor("#E7D5A5")
                cardViewSecond[0].visibility = View.VISIBLE
                cardViewFirst[0].visibility = View.GONE
                tvTitleToolbar.text = getString(R.string.arrastra_tu_carta, "segunda")
            }
            R.id.cardView2 -> {
                textViewSecondName.text = model.name
                cardViewThird.setOnDragListener(maskDragListener)
                cardViewThird.strokeColor = Color.parseColor("#E7D5A5")
                cardViewThird[0].visibility = View.VISIBLE
                cardViewSecond[0].visibility = View.GONE
                tvTitleToolbar.text = getString(R.string.arrastra_tu_carta, "tercera")
            }

            R.id.cardView3 -> {
                textViewThirdName.text = model.name
                btnShowDetails.visibility = View.VISIBLE
                image.visibility = View.GONE
                cardViewThird[0].visibility = View.GONE
            }
        }
    }


    private fun attachViewDragListener() {

        // 1
        image.setOnLongClickListener { view: View ->

            // 2
            val item = ClipData.Item(cardDraggedMessage)

            // 3
            val dataToDrag = ClipData(
                cardDraggedMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // 4
            val maskShadow = MaskDragShadowBuilder(view)

            // 5
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            //7
            true
        }
    }

}

