package com.example.mobile_app.Cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Cart_DAO {
    @Insert
    suspend fun insertCarts (carts: Carts)

    @Update
    suspend fun updateCarts(carts: Carts)

   @Query("DELETE FROM Cart_Receive WHERE Cart_Id = :CartID")
    suspend fun deleteCarts(CartID: Int)

    @Delete
    suspend fun deletrCarts(carts: Carts)

    @Query("SELECT * FROM Cart_Receive")

    fun getalldata():LiveData<List<Carts>>

}