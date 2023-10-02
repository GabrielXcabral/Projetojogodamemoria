package com.example.jogodamemoria

import android.widget.ImageView

class Carta(id: Int, imagemId: Int) {
    private val id: Int = id;
    private var isViradaParaCima: Boolean = false;
    private val isEncontrada: Boolean = false;
    private val imagemId: Int = imagemId;
    private var imagemView: ImageView? = null

    fun getId (): Int{
        return id;
    }

    fun getIsViradaParaCima ():Boolean{
        return isViradaParaCima;
    }

    fun getImagemId():Int{
        return imagemId;
    }

    fun getImagemView(): ImageView? {
        return imagemView;
    }

    fun setImgemView(imageview: ImageView){
        this.imagemView = imageview;
    }

    fun virarcarta(carta: Carta){
        carta.isViradaParaCima = !isViradaParaCima

        if (carta.isViradaParaCima){
            imagemView?.setImageResource(carta.imagemId)
        }
        else{
            imagemView?.setImageResource(R.drawable.cartadecosta);
        }

    }

}