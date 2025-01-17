package com.example.mobile_app.ProductDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName="Product_Information")
data class Products(


    @PrimaryKey(autoGenerate = false)
    var Pid:Int,

    val name: String,
    val type: String,
    val price: Int,
    val imageResId: Int // Resource ID for product image
)

//
//
//    @ColumnInfo(name = "productName")
//    var textProductName: String,
//
//    @ColumnInfo(name = "productDescription")
//    var textProductDescription: String,
//
//    @ColumnInfo(name = "productPrice")
//    var textProductPrice: Double,
//
//    @ColumnInfo(name = "productRating")
//    var textProductRating: Double,
//
//    @ColumnInfo(name = "productImage")
//    var imageProduct: Int,
//
//)