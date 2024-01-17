package com.FrogDomo.Model


import java.io.Serializable

class User(
    var username: String,
    var email: String,
    var password: String,
    var lampe: Lampe,
    var fan: Fan,
    var alarm: Alarm,
    var portail: Int,
)
