package com.example.tarot.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarot.R
import com.example.tarot.model.TarotImage

class CardImagDescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvCardName = itemView.findViewById(R.id.tvCardName) as TextView
    private val ivCardDetail = itemView.findViewById(R.id.ivCardDetail) as ImageView

    fun bind(model: TarotImage) {
        tvCardName.text = model.name
        ivCardDetail.setImageResource(model.route)
    }

}