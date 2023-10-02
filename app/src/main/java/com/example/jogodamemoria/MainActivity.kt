package com.example.jogodamemoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridlayout = findViewById<GridLayout>(R.id.gridLayout);
        val bntJogar = findViewById<Button>(R.id.bntIniciar);
        var jogoIniciado: Boolean = false;

        val jogo = Jogo();

        val idsCartas = listOf(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8).shuffled();
        val cards = idsCartas.mapIndexed { index, value ->
            val imagemCarta = resources.getIdentifier("card_$value", "drawable", packageName);
            Carta(id = value, imagemId = imagemCarta)
        }
        var compararcarta = mutableListOf<Carta>();

        for (carta in cards) {
            val imageView = ImageView(this);
            val layoutParams = ViewGroup.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.image_height), // Substitua por uma dimensão desejada
                resources.getDimensionPixelSize(R.dimen.image_width),  // Substitua por uma dimensão desejada
            )
            imageView.layoutParams = layoutParams;
            imageView.setImageResource(carta.getImagemId());

                bntJogar.setOnClickListener {
                    jogo.setSituacaodojogo(true);
                    bntJogar.isEnabled = false
                }

                imageView.setOnClickListener() {
                    if(jogo.getStiuacaodojogo()) {
                        if (!carta.getIsViradaParaCima()) {
                            carta.virarcarta(carta);
                            compararcarta.add(carta);
                            if (compararcarta.size == 2) {
                                if (compararcarta[0].getId() == compararcarta[1].getId()) {
                                    jogo.cartaFoiEncontrada(compararcarta[0], compararcarta[1]);
                                    compararcarta.clear();
                                    if(jogo.getCartasEncontradas() == 16){
                                        val  intent = Intent(this, TelaVitoria::class.java);
                                        startActivity(intent);
                                    }
                                } else {
                                    Handler().postDelayed({
                                        compararcarta[0].virarcarta(compararcarta[0]);
                                        compararcarta[1].virarcarta(compararcarta[1]);
                                        compararcarta.clear()
                                    }, 1000)
                                }
                            }
                        }
                    }
                }


            gridlayout.addView(imageView);
            carta.setImgemView(imageView);


        }

        Handler().postDelayed({
            for (carta in cards) {
                val imageview = carta.getImagemView();
                imageview?.setImageResource(R.drawable.cartadecosta);
            }
            gridlayout.invalidate();
        }, 10000)
    }
}