package com.example.citasmedicas

class Paciente {
    var idPaciente : Int = 0
    var peso : Int = 0
    var estatura : Int = 0

    constructor( peso : Int, estatura : Int){
        this.peso = peso
        this.estatura = estatura
    }

    constructor(){
    }

}