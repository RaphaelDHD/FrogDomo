package com.FrogDomo.DataSource

import com.FrogDomo.Model.User

class CacheDataSource private constructor() {
    private var userLogin: User = User(username = "", email = "")

    // Méthode pour définir l'utilisateur
    fun setUserLogin(user: User) {
        this.userLogin = user
    }

    // Méthode pour récupérer l'utilisateur
    fun getUserLogin(): User {
        return userLogin
    }

    // Singleton
    companion object {
        @Volatile
        private var instance: CacheDataSource? = null

        fun getInstance(): CacheDataSource {
            return instance ?: synchronized(this) {
                instance ?: CacheDataSource().also { instance = it }
            }
        }
    }
}