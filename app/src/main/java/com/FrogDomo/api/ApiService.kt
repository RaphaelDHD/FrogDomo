package com.FrogDomo.api

import com.FrogDomo.Model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id : Int): Response<User>

    @POST("users")
    suspend fun createUser(user: User)

    @POST("users/login")
    suspend fun login(email: String, password: String): Response<User>

    @PUT("users/{id}")
    suspend fun updateConfig(user: User)

}