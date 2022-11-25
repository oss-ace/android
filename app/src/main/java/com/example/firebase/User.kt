package com.example.firebase

data class User(
    var name:String,
    var Date:String,
    var email:String,
    var uId:String
){
    constructor():this("","","","")
}
