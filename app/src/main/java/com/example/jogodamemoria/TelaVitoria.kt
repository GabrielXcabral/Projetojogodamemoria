package com.example.jogodamemoria

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaVitoria : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_vitoria)

        val voltar = findViewById<Button>(R.id.bntVoltar);

        voltar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java);
            startActivity(intent);
        }
    }
}