package com.example.tarot.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarot.R
import com.example.tarot.model.TarotImage

class CardImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvName = itemView.findViewById(R.id.tvName) as TextView
    private val ivCard = itemView.findViewById(R.id.ivCard) as ImageView

    fun bind(model: TarotImage) {
        tvName.text = model.name
        ivCard.setImageResource(model.route)
    }
}
