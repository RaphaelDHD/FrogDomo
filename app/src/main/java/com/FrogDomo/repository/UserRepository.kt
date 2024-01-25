package com.FrogDomo.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.FrogDomo.Model.User
import com.FrogDomo.api.ApiClient
import com.FrogDomo.api.ApiService
import com.FrogDomo.api.LoginRequest
import kotlin.random.Random

object UserRepository {

    private var _currentUser : MutableLiveData<User> = MutableLiveData<User>()
    val currentUser = _currentUser


    /*suspend fun login(email: String, password: String): User? {
        val user = ApiClient.apiService.login(LoginRequest(email, password))
        return user.body()
    }*/

    fun registerUserToSharedPreferences(context: Context, email: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("SpizeurSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.apply()
    }

    fun getUserFromSharedPreferences(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("SpizeurSharedPreference", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", null)
        return email
    }

    fun logout() {

    }



}