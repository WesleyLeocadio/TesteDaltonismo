package com.example.daltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_teste.*

class TesteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        var params = intent.extras
        var texto = params?.getInt("codImagem")
        if (texto == 1) {
            idImagem.setImageResource(R.drawable.img2)
        }
        if (texto == 2) {
            idImagem.setImageResource(R.drawable.img12)
        }
        if (texto == 3) {
            idImagem.setImageResource(R.drawable.img16)
        }

        btnCancelar.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
    }

}
