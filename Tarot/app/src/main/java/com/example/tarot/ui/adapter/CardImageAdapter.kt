package com.example.tarot.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarot.R
import com.example.tarot.model.TarotImage

class CardImageAdapter(private val model: List<TarotImage>) : RecyclerView.Adapter<CardImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_cards, parent, false)
        return CardImageViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardImageViewHolder, position: Int) {
        holder.bind(model[position])
    }
    override fun getItemCount() = model.size
}