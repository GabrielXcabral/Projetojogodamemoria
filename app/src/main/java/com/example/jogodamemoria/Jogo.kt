package com.example.jogodamemoria

import android.view.ViewGroup
import android.widget.ImageView

class Jogo {
    private  var cartasEncontradas = mutableListOf<Carta>()
    private var jogoIniciado: Boolean = false;

    constructor() {
        cartasEncontradas = mutableListOf()
    }

    fun cartaFoiEncontrada (carta1: Carta, carta2: Carta){
        this.cartasEncontradas.add(carta1);
        this.cartasEncontradas.add(carta2);
    }

    fun getStiuacaodojogo (): Boolean{
        return jogoIniciado;
    }

    fun setSituacaodojogo(novaSituacao: Boolean){
        jogoIniciado = novaSituacao;
    }

    fun getCartasEncontradas(): Int{
        return this.cartasEncontradas.size;

    }


}