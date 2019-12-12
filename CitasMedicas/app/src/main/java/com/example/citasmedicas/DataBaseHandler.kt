package com.example.citasmedicas

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


//TABLA PARA LA CITA
val DATABASE_NAME = "DB_CitasMedicass"
val TABLE_NAME = "Citas"
val COL_IDCITA = "id"
val COL_FECHA = "fecha"
val COL_MOTIVO = "motivo"
val COL_ESTADO = "estado"
val COL_NOMMEDICO = "nombreMedico"
val COL_ESPECIALIDA = "especialidadMedico"
val COL_NOMPACIENTE = "nombrePaciente"
val COL_IDPACIENTE = "identidadPaciente"

//TABLA PARA EL PERFIL DEL PACIENTE
val TABLE_NAMES = "Pacientes"
val COL_PESO = "peso"
val COL_AL  = "Altura"
val COL_IDD = "id"

class DataBaseHandler (var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" ("+
                COL_IDCITA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_FECHA + " TEXT NOT NULL," +
                COL_MOTIVO + " TEXT NOT NULL," +
                COL_ESTADO + " TEXT NOT NULL," +
                COL_NOMMEDICO + " TEXT NOT NULL," +
                COL_ESPECIALIDA + " TEXT NOT NULL," +
                COL_IDPACIENTE + " TEXT NOT NULL," +
                COL_NOMPACIENTE + " TEXT NOT NULL)"
        db?.execSQL(createTable)

        val createTable1 =  "CREATE TABLE " + TABLE_NAMES + " ("+
                COL_IDD + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_PESO + " INTEGER NOT NULL," +
                COL_AL + " INTEGER NOT NULL)"
        db?.execSQL(createTable1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun inserData(cita: Cita){

        val db =  this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_FECHA, cita.fecha)
        cv.put(COL_MOTIVO, cita.motivo)
        cv.put(COL_ESTADO, cita.estado)
        cv.put(COL_NOMMEDICO, cita.nombreMedico)
        cv.put(COL_ESPECIALIDA, cita.especialidadMedico)
        cv.put(COL_IDPACIENTE, cita.idPaciente)
        cv.put(COL_NOMPACIENTE, cita.nombrePaciente)

        var result = db.insert(TABLE_NAME, null, cv)

        if(result == -1.toLong())
            Toast.makeText(context, "Registro no guardado", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Registro guardado corectamente", Toast.LENGTH_SHORT).show()
    }
    fun inserDataP(paciente: Paciente){
        val db = this.writableDatabase
        var cvx = ContentValues()

        cvx.put(COL_PESO, paciente.peso)
        cvx.put(COL_AL,paciente.estatura)

        var resultt = db.insert(TABLE_NAMES,null,cvx)

        if(resultt == -1.toLong())
            Toast.makeText(context, "Registro no guardado", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Registro guardado corectamente", Toast.LENGTH_SHORT).show()

    }
    fun updateData(){
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query,null)
        do {
            var cv = ContentValues()
            cv.put(COL_IDPACIENTE,result.getString(result.getColumnIndex(COL_IDPACIENTE)))
            db.update(TABLE_NAME, cv, COL_IDCITA + " =? AND" + COL_NOMPACIENTE + "=?",
                arrayOf(result.getString(result.getColumnIndex(COL_IDCITA)),
                    result.getString(result.getColumnIndex(COL_NOMPACIENTE)),
                    result.getString(result.getColumnIndex(COL_FECHA)),
                    result.getString(result.getColumnIndex(COL_MOTIVO)),
                    result.getString(result.getColumnIndex(COL_ESTADO)),
                    result.getString(result.getColumnIndex(COL_NOMMEDICO)),
                    result.getString(result.getColumnIndex(COL_ESPECIALIDA)))
                )
        }while (result.moveToFirst())
        result.close()
        db.close()
    }
    fun readData() : MutableList<Cita>{
        var list : MutableList<Cita> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do{
                var cita = Cita()
                cita.idCita = result.getString(result.getColumnIndex(COL_IDCITA)).toInt()
                cita.fecha = result.getString(result.getColumnIndex(COL_FECHA))
                cita.motivo = result.getString(result.getColumnIndex(COL_MOTIVO))
                cita.estado = result.getString(result.getColumnIndex(COL_ESTADO))
                cita.nombreMedico = result.getString(result.getColumnIndex(COL_NOMPACIENTE))
                cita.especialidadMedico = result.getString(result.getColumnIndex(COL_ESPECIALIDA))
                cita.idPaciente = result.getString(result.getColumnIndex(COL_IDPACIENTE))
                cita.nombrePaciente = result.getString(result.getColumnIndex(COL_NOMPACIENTE))

                list.add(cita)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

}