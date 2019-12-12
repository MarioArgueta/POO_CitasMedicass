package com.example.citasmedicas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_anular__cita.*

class Anular_Cita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anular__cita)

        val context = this
        var db = DataBaseHandler(context)

       btnBuscar.setOnClickListener {
            var data = db.readData()
            for (i in 0..(data.size - 1)) {
                txiIdentidadP.append(data.get(i).idPaciente.toString())
                txtNombreP.append(data.get(i).nombrePaciente.toString())
                txtFecha.append(data.get(i).fecha.toString())
                txiMotivoP.append(data.get(i).motivo.toString())
                txiEstadoP.append(data.get(i).estado.toString())
                sppEspecialidad.append(data.get(i).especialidadMedico.toString())
                sppMedico.append(data.get(i).nombreMedico.toString())
            }
        }
        btnActualizar.setOnClickListener {
            db.updateData()
            btnBuscar.performClick()
        }
    }

}
