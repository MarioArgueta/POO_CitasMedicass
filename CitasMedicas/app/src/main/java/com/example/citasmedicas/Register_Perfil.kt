package com.example.citasmedicas

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_register__perfil.*

class Register_Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register__perfil)

        val context = this

        btnGuardd.setOnClickListener {
            if (txtPeso.text.toString().length > 0 && txtAltura.text.toString().length > 0){

                var paciente = Paciente(txtPeso.text.toString().toInt(),txtAltura.text.toString().toInt())

                var db1 = DataBaseHandler(context)

                db1.inserDataP(paciente)

            }
            else{
                Toast.makeText(context,"¡Por favor llene todos los campos!",Toast.LENGTH_SHORT).show()
            }

        }
    }

}
