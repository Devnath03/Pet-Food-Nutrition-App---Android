package com.example.mobile_app.ProductDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Products::class], version = 1)
abstract class ProductsDB : RoomDatabase() {

    abstract fun productsdao(): Products_DAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsDB? = null

        fun getInstance(context: Context): ProductsDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDB::class.java,
                    "products_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
