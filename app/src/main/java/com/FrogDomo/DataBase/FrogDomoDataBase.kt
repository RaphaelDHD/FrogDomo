package com.FrogDomo.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.FrogDomo.DataBase.Dao.UserDAO
import com.FrogDomo.Model.User

@Database(entities = [User::class], version = 1
)
internal abstract class FrogDomoDataBase : RoomDatabase() {

    abstract fun UserDAO(): UserDAO

    companion object {

        private lateinit var instance: FrogDomoDataBase
        fun initDatabase(context: Context) {
            instance = Room.databaseBuilder(
                context, FrogDomoDataBase::class.java,
                "frog-db"
            ).build()
        }


        fun getInstance(): FrogDomoDataBase {
            return instance
        }
    }
}
