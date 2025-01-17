package com.example.mobile_app.UserDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Users_DAO {
    @Insert
    suspend fun insertUsers (user:Users)

    @Update
    suspend fun updateUser(user: Users)

    @Query("DELETE FROM User_Information WHERE User_Id = :UserId")
    suspend fun deleteUser(UserId: Int)

    @Delete
    suspend fun deleteDrugs(user: Users)

    @Query("SELECT * FROM User_Information")

    fun getalldata():LiveData<List<Users>>

    // Login method to get user data by email and password
    @Query("SELECT * FROM User_Information WHERE email = :email AND password = :password LIMIT 1")
    suspend fun loginUser(email: String, password: String): Users?

//        @Query("SELECT * FROM User_Information WHERE email = :email AND password = :password")
//        suspend fun getUserByEmailAndPassword(email: String, password: String): Users?
//
}