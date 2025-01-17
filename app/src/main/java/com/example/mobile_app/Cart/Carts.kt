package com.example.mobile_app.Cart

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName="Cart_Receive")
data class Carts(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Cart_Id")
    var Cid: Int,

    @ColumnInfo(name = "Product_Name")
    var CName: String,

    @ColumnInfo(name = "Number Of Items")
    var Citems: Int,

    @ColumnInfo(name = "Payment Method")
    var Cpayment: String,


    )