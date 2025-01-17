package com.example.mobile_app.Cart

import androidx.lifecycle.LiveData
import com.example.mobile_app.Cart.Cart_DAO
import com.example.mobile_app.Cart.Carts
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch


class Cart_ViewModel (private val dao:Cart_DAO):ViewModel(){

    val foc = dao.getalldata()

    fun insertCarts(carts: Carts) = viewModelScope.launch{
        dao.insertCarts(carts)
    }
    fun updateCarts(carts: Carts) = viewModelScope.launch{
        dao.updateCarts(carts)
    }
    fun deleteCarts(CartID: Int) = viewModelScope.launch{
        dao.deleteCarts(CartID)
    }


    val allcarts: LiveData<List<Carts>> = dao.getalldata()
}