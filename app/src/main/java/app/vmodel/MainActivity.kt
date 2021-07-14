package app.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        //observando a variavel que está dentro do ViewModel
        mViewModel.mContador.observe(this, Observer {
            valor -> txtContador.setText(valor)
        })
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            mViewModel.contador()
        }

        btnMostrar.setOnClickListener {
           Toast.makeText(applicationContext,"Valor contador: ${mViewModel.mContador.value}",Toast.LENGTH_SHORT).show()
        }
    }
}