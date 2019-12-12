package com.example.citasmedicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnlogin.setOnClickListener {
            val intent: Intent = Intent(this, Menu_Userx::class.java )
            startActivity(intent)
        }
        btnregistro.setOnClickListener {
            val intent1 : Intent = Intent(this, register_user::class.java)
            startActivity(intent1)
        }
    }

    //private val EditText dtxtUsuario



}


