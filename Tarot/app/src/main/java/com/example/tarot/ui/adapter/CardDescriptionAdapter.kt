package com.example.tarot.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarot.R
import com.example.tarot.model.TarotImage

class CardDescriptionAdapter(private val model: List<TarotImage>) :
    RecyclerView.Adapter<CardImagDescriptionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImagDescriptionViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_cards_detail, parent, false)
        return CardImagDescriptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardImagDescriptionViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount() = model.size
}