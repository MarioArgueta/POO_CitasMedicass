package com.example.citasmedicas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_loginx.*

class loginx : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPassword: EditText
    private lateinit var progressBar : ProgressBar
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginx)

        txtUser=findViewById(R.id.txtUsuario)
        txtPassword=findViewById(R.id.txtContra)

        progressBar= findViewById(R.id.progressBar2)
        auth=FirebaseAuth.getInstance()

    }

    fun loging(view: View){
        loginUser()
    }
    fun regirter(view: View){
        startActivity(Intent(this, register_user::class.java))
    }

    fun loginUser(){
        val user: String = txtUser.text.toString()
        val password: String = txtPassword.text.toString()

        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)){
            progressBar.visibility=View.VISIBLE

            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        action()
                    }else{
                        Toast.makeText(this,"Error en la autenticacion", Toast.LENGTH_LONG)
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this, Menu_Userx::class.java))
    }
}
