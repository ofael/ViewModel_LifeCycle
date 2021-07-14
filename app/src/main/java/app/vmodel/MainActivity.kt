package app.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    var contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logar(valor = "onCreat")

        initDados()
        initContador()
        initClick()

        validaContador()
    }

    override fun onStart() {
        super.onStart()
        logar(valor = "OnStart")
    }

    override fun onResume() {
        super.onResume()
        logar(valor = "onResume")
    }

    override fun onPause() {
        super.onPause()
        logar(valor = "onPause")
    }

    override fun onStop() {
        super.onStop()
        logar(valor ="onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logar(valor="onDestroy")
    }

    private fun logar (tag: String = "Ciclo de vida", valor: String){
        Log.d(tag,valor)
    }

    private fun validaContador() {
        if(contador > 5){
            contador = 0
        }
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            contador ++
            validaContador()
            initContador()
        }

        btnMostrar.setOnClickListener {
           Toast.makeText(this,"Valor contador: $contador",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initContador() {
       txtContador.setText(contador.toString())
    }

    private fun initDados() {
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
    }
}