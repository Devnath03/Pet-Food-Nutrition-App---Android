package com.example.mobile_app.Cart

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities=[Carts::class],version=1,exportSchema=false)
abstract class CartDB:RoomDatabase(){

    abstract fun cartdao():Cart_DAO

    companion object {

        @Volatile
        private var INSTANCE: CartDB? = null

        fun getInstance(context: Context): CartDB {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(

                        context.applicationContext,
                        CartDB::class.java,
                        "Carts_Database"
                    ).build()
                }
                return instance
            }
        }

    }
}
