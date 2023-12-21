package com.FrogDomo.DataBase

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.FrogDomo.Model.User
import com.FrogDomo.DataBase.Dao.UserDAO

@Database(entities = [User::class], version = 1
)
internal abstract class FrogDomoDataBase : RoomDatabase() {

    abstract fun UserDAO(): UserDAO

    companion object {

        private lateinit var instance: FrogDomoDataBase
        fun initDatabase(context: Context) {
            instance = Room.databaseBuilder(
                context, FrogDomoDataBase::class.java,
                "city-db"
            ).build()
        }


        fun getInstance(): FrogDomoDataBase {
            return instance
        }
    }
}
