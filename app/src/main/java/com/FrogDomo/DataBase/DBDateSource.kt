package com.FrogDomo.DataBase


import com.FrogDomo.Model.User

object DBDataSource{

    suspend fun insertUser(user: User) {
        FrogDomoDataBase.getInstance().UserDAO().insertUser(user)
    }
    suspend fun getUser(mail: String) :User {
        return FrogDomoDataBase.getInstance().UserDAO().getUserFromMail(mail);
    }
    suspend fun updateUser(user: User){
        FrogDomoDataBase.getInstance().UserDAO().updateUsers(user)
    }

}
