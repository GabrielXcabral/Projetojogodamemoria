package com.example.jogodamemoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridlayout = findViewById<GridLayout>(R.id.gridLayout);

        val idsCartas = listOf(1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8).shuffled();
        val cards = idsCartas.mapIndexed {index, value ->
            val imagemCarta = resources.getIdentifier("card_$value", "drawable", packageName);
            Carta(id = index, imagemId = imagemCarta)
        }

        for ((index, carta) in cards.withIndex()){
            val imageView = ImageView(this);
            imageView.setImageResource(R.drawable.cartadecosta);

            /*imageView.setOnClickListener(){
                if(!carta.getIsViradaParaCima()){
                    carta.virarcarta(carta);
                    //imageView.setImageResource(carta.getImagemId());
                }
            }*/
            gridlayout.addView(imageView);
            carta.setImgemView(imageView);
        }

    }
}