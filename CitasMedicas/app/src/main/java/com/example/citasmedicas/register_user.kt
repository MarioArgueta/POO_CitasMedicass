package com.example.citasmedicas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class register_user : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtUserx: EditText
    private lateinit var txtLastname: EditText
    private lateinit var txtPassword: EditText

    private lateinit var progressBar : ProgressBar
    private lateinit var dbreference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_userx)

        txtName=findViewById(R.id.txtName)
        txtLastname=findViewById(R.id.txtApellido)
        txtUserx=findViewById(R.id.txtUsuario)
        txtPassword=findViewById(R.id.txtContra)

        progressBar= findViewById(R.id.progressBar)

        database = FirebaseDatabase.getInstance()
        auth=FirebaseAuth.getInstance()

        dbreference=database.reference.child("User")
    }

    fun register(view: View){
        createNewAccount()
    }

    private fun createNewAccount(){
        val name: String = txtName.text.toString()
        val lastname:String = txtLastname.text.toString()
        val userx: String = txtUserx.toString()
        val password: String = txtPassword.text.toString()


        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(lastname) && !TextUtils.isEmpty(userx)){
            progressBar.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(userx,password)
                .addOnCompleteListener(this){
                    task ->

                    if(task.isComplete){
                        val user:FirebaseUser? = auth.currentUser
                        veryEmail(user)

                        val userBD = dbreference.child(user?.uid.toString())

                        userBD.child("Name").setValue(name)
                        userBD.child("LastName").setValue(lastname)
                        action()
                    }
                }
        }
    }
    private fun action(){
        startActivity(Intent(this, loginx::class.java))
    }
    private fun veryEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if (task.isComplete){
                    Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG)
                }else{
                    Toast.makeText(this,"Error al enviar el Email",Toast.LENGTH_LONG)
                }
            }
    }
}
