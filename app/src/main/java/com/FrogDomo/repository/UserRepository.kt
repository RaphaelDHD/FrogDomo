package com.example.spizeur.domain

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.FrogDomo.Model.User
import com.FrogDomo.api.ApiClient
import com.FrogDomo.api.ApiService
import kotlin.random.Random

object UserRepository {

    private var _currentUser : MutableLiveData<User> = MutableLiveData<User>()
    val currentUser = _currentUser


    suspend fun login(email: String, password: String): User? {
        val user = ApiClient.apiService.login(email,password)
        return user.body()
    }

    suspend fun getUser(email: String): User {
        return DBDataSource.getUser(email)
    }

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

    suspend fun userExist(email: String): Boolean {
        val User = DBDataSource.getUser(email)
        if (User != null) {
            return true
        }
        return false
    }


    suspend fun createAccount(username: String, email: String, password: String) {
        val user = User(userId= Random.nextInt(0,100000),username = username, email = email, password = password)
        _currentUser.value = user
        createOrderIfNoCurrent(user.userId!!)
        DBDataSource.insertUser(user)
    }

    fun logout() {

    }

    fun createOrderIfNoCurrent(userId: Int) {
        if (_currentUserOrder.value == null) {
            val order = Order(userCommandId = userId)
            _currentUserOrder.value = order
        }
    }



}