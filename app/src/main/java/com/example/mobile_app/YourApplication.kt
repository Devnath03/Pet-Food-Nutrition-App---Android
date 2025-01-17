package com.example.mobile_app

import android.app.Application
import com.example.mobile_app.ProductDB.ProductsDB

class YourApplication : Application() {
    lateinit var database: ProductsDB
        private set

    override fun onCreate() {
        super.onCreate()
        // Initialize the Room database instance
        database = ProductsDB.getInstance(this)
    }
}