package com.example.daltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val MY_RESULT_CODE1 = 99
    val MY_RESULT_CODE2= 98
    val MY_RESULT_CODE3= 97

    val CODE1 = 1
    val CODE2 = 2
    val CODE3 = 3

    var resposta_1=0
    var resposta_2=0
    var resposta_3=0

    var resultado="Resultado:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResp1.text=resposta_1.toString()
        textResp2.text=resposta_2.toString()
        textResp3.text=resposta_3.toString()
        textResultado.text= ("$resultado 0")

        btnTeste1.setOnClickListener(this)
        btnTeste2.setOnClickListener(this)
        btnTeste3.setOnClickListener(this)
    }


    override fun onClick(view: View) {

        val id = view.id
        var i = Intent(this, TesteActivity::class.java)
        var cod=0
       // var b = Bundle()
        //var p:Pessoa =  Pessoa(editUsuario.text.toString(),editSenha.text.toString())
        //b.putString("Senha", editSenha.text.toString())

        //i.putExtras(b)

        if(id==R.id.btnTeste1){

              cod=CODE1

        }
        if(id==R.id.btnTeste2){
            cod=CODE2
        }
        if(id==R.id.btnTeste3){

            cod=CODE3


        }

         var b = Bundle()
        b.putInt("codImagem",cod)
        i.putExtras(b)
        startActivity(i)

    }
}
