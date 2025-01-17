package com.example.mobile_app.UserDB

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Users::class],version=1,exportSchema=false)
abstract class UsersDB:RoomDatabase(){
    abstract fun userssdao():Users_DAO

    companion object {
        @Volatile
        private var INSTANCE: UsersDB? = null

        fun getInstance(context: Context): UsersDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDB::class.java,
                        "Users_Data_Database"
                    ).build()
                }
                return instance
            }
        }

    }
}
