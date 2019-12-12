package com.example.citasmedicas

class Cita {

    var idCita : Int = 0
    var fecha : String = ""
    var motivo: String = ""
    var estado : String = ""
    var especialidadMedico : String = ""
    var nombreMedico : String = ""
    var nombrePaciente :String = ""
    var idPaciente : String = ""

    constructor( fecha:String, motivo :String, especialidadMedico :String, nombreMedico: String, idPaciente:String, nombrePaciente :String, estado:String){
        this.fecha = fecha
        this.motivo = motivo
        this.estado = estado
        this.especialidadMedico = especialidadMedico
        this.nombreMedico = nombreMedico
        this.idPaciente  = idPaciente
        this.nombrePaciente = nombrePaciente
    }

    constructor(){
    }
}