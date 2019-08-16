package com.example.daltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val MY_RESULT_CODE1 = 99
    private val MY_RESULT_CODE2 = 98
    private val MY_RESULT_CODE3 = 97

    private val CODE1 = 1
    private val CODE2 = 2
    private val CODE3 = 3

    private var resposta_1 = 0
    private var resposta_2 = 0
    private var resposta_3 = 0

    var resultado = "Resultado"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResp1.text = resposta_1.toString()
        textResp2.text = resposta_2.toString()
        textResp3.text = resposta_3.toString()
        textResultado.text = ("$resultado")

        btnTeste1.setOnClickListener(this)
        btnTeste2.setOnClickListener(this)
        btnTeste3.setOnClickListener(this)

        btnVerificar.setOnClickListener {
            try {
                if (teste()) textResultado.text = "Sem sintomas" else textResultado.text = "DALTÔNICO"
            } catch (e: NumberFormatException) {
                textResultado.text = "Dados incorretos!"
                Toast.makeText(this, "VALORES INCORRETOS!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onClick(view: View) {
        val id = view.id
        var i = Intent(this, TesteActivity::class.java)
        var cod = 0
        var result = 0

        when(id){
            R.id.btnTeste1->{
                cod = CODE1
                result = MY_RESULT_CODE1
            }
            R.id.btnTeste2->{
                cod = CODE2
                result = MY_RESULT_CODE2
            }
            R.id.btnTeste3->{
                cod = CODE3
                result = MY_RESULT_CODE3
            }
        }

        var b = Bundle()
        b.putInt("codImagem", cod)
        i.putExtras(b)
        startActivityForResult(i, result)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val t = data?.getStringExtra("RESPOSTA")

        when (requestCode) {
            MY_RESULT_CODE1 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        textResp1.text = t
                    }
                }
            }
            MY_RESULT_CODE2 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        textResp2.text = t
                    }
                }
            }
            MY_RESULT_CODE3 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        textResp3.text = t
                    }
                }
            }

        }


    }

    private fun teste(): Boolean =textResp1.text.toString().toInt() == 2 && textResp2.text.toString().toInt() == 12 && textResp3.text.toString().toInt() == 16


}

