package com.example.daltonismo

import android.app.Activity
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
        when (texto) {
            1 -> {idImagem.setImageResource(R.drawable.img2)}
            2 -> { idImagem.setImageResource(R.drawable.img12)}
            3 -> {idImagem.setImageResource(R.drawable.img16)}
        }

        btnOk.setOnClickListener {
            var i = Intent()
            i.putExtra("RESPOSTA", editText.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

}
