package com.example.mobile_app.UserDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName="User_Information")
data class Users(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "User_Id")
    var Did: Int,

    @ColumnInfo(name = "Username")
    var Username: String,

    @ColumnInfo(name = "Email")
    var Email: String,

    @ColumnInfo(name = "Age")
    var Age: Int,

    @ColumnInfo(name = "Petname")
    var PetName: String,

    @ColumnInfo(name = "Password")
    var Password: Int,
    )
