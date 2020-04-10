package com.example.imagelibrary.POJO

class ProfileData {
    lateinit var name:String
    lateinit var email:String
    lateinit var password:String

    constructor(name:String,email:String,password:String)
    {
       this.email=email
        this.name=name
        this.password=password
    }

}