package com.example.eva.Model

class Code {
    var id:Int = 0
    var titulo:String? = null
    var descripcion:String? = null
    var codigo:String? = null

    constructor(){}

    constructor(titulo:String,descripcion:String,codigo:String){

        this.titulo = titulo
        this.descripcion = descripcion
        this.codigo = codigo
    }
}