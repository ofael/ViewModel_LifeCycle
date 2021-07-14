package app.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //declarando uma variavel na view model
    var mContador = MutableLiveData<String>().apply { value = contador.toString() }
    private var contador: Int = 0

    private fun setmContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador() {
        contador++
        if(contador > 5){
            contador = 0
        }

        setmContador()
    }

    fun contador(){
        validaContador()
    }
}