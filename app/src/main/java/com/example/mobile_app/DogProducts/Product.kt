package com.example.mobile_app.DogProducts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val description: String,
    val imageUri: String // Store the URI of the image as a String
)