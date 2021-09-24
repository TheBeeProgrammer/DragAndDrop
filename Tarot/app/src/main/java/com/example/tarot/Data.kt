package com.example.tarot

import android.graphics.Color
import com.example.tarot.model.TarotImage
import java.util.*

object Data {
    var tarotList = arrayListOf<TarotImage>()
    fun getData(): List<TarotImage> {
        tarotList.add(
            TarotImage(
                UUID.randomUUID(), R.drawable.el_carro, "El Carro"
            )
        )
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_colgado, "El Colgado"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_diablo, "El Diablo"))
        tarotList.add(
            TarotImage(
                UUID.randomUUID(), R.drawable.el_emperador, "El Emperador"
            )
        )
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_juicio, "El Juicio"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_loco, "El Loco"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_mago, "El Mago"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.el_sol, "El Sol"))
        tarotList.add(
            TarotImage(
                UUID.randomUUID(), R.drawable.hermitano, "Hermitaño"
            )
        )
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_emperatriz, "La Emperatriz"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_estrella, "La Estrella"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_fuerza, "La Fuerza"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_justicia, "La Justicia"))
        tarotList.add(
            TarotImage(
                UUID.randomUUID(), R.drawable.la_luna, "La Luna"
            )
        )
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_sacerdotisa, "La Sacerdotisa"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.la_torre, "La Torre"))
        tarotList.add(TarotImage(UUID.randomUUID(), R.drawable.los_enamorados, "Los Enamorados"))
        tarotList.add(
            TarotImage(
                UUID.randomUUID(),
                R.drawable.rueda_de_la_fortuna,
                "Rueda De La Fortuna"
            )
        )

        return tarotList.toMutableList().shuffled()
    }
}