package com.example.citasmedicas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.menu_user.*

class Menu_Userx : AppCompatActivity() {


    internal lateinit var activity : Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_user)

        cdGenerar.setOnClickListener{
            startActivity(Intent(this, RegirtrarCitax::class.java))
        }
        cdAnular.setOnClickListener {
            startActivity(Intent(this, Anular_Cita::class.java))
        }
        cdPerfil.setOnClickListener{
            startActivity(Intent(this, Register_Perfil::class.java))
        }
        cdCerrar.setOnClickListener {
            startActivity(Intent(this, loginx::class.java))
        }
    }



}
