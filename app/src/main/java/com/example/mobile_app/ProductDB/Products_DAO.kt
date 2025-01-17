package com.example.mobile_app.ProductDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface Products_DAO {
    @Insert
    suspend fun insertProducts (product: Products)

//    @Update
//    suspend fun updateDrugs(drug:Drugs)
//
//    @Query("DELETE FROM Drug_Types WHERE Drug_Id = :drugId")
//    suspend fun deleteDrugs(drugId: Int)

//    @Delete
//    suspend fun deleteDrugs(drug:Drugs)

    @Query("SELECT * FROM Product_Information")

    fun getalldata():LiveData<List<Products>>

}