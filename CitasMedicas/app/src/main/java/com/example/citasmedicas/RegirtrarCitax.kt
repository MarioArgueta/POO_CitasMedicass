package com.example.citasmedicas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_regirtrar_citax.*

class RegirtrarCitax : AppCompatActivity() {

    lateinit var option :Spinner
    lateinit var  masoption : Spinner

    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regirtrar_citax)

        val myString1 = arrayOf("Ginecologia", "Gastrointelogia", "Odontologia", "Cardiologia")
        val myString2 = arrayOf("Tulio Hernandez", "Julio Lopez","Rodrigo Rodriguez")

        sppEspecialidad.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, myString1)
        sppMedico.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, myString2)

        sppEspecialidad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context, myString1[position], LENGTH_LONG).show()
            }

        }
        sppMedico.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context, myString1[position], LENGTH_LONG).show()
            }

        }


        btnGuardar.setOnClickListener{
            if (txtFecha.text.toString().length > 0 && txtNombreP.text.toString().length > 0
                && txtPeso.text.toString().length > 0 && txiMotivoP.text.toString().length > 0){

                var cita = Cita(txtFecha.text.toString(),txiMotivoP.text.toString(),sppEspecialidad.selectedItem.toString(), sppMedico.selectedItem.toString(),txtPeso.text.toString(),txtNombreP.text.toString(), txiEstadoP.text.toString())

                var db = DataBaseHandler(context)

                db.inserData(cita)

            }
            else{
                Toast.makeText(context,"¡Por favor llene todos los campos!",Toast.LENGTH_SHORT).show()
            }

        }
    }
    }


