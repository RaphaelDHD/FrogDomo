package com.FrogDomo.Model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(indices = [Index(
    value = ["email"],
    unique = true
)])
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    var username: String,
    var email: String,
    var password: String? = null,
    var avatar: String? = null,
) : Serializable


data class LoginUser(
    var userEmail: String,
    var password: String,
)