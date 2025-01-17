package com.example.mobile_app.Cart


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.Cart.Cart_DAO
import kotlin.IllegalArgumentException

class Cart_ViewModelFactory (

    private val dao: Cart_DAO

):ViewModelProvider.Factory{

    override fun <T:ViewModel> create (modelClass:Class<T>):T{

        if(modelClass.isAssignableFrom(Cart_ViewModel::class.java)){

            return Cart_ViewModel(dao) as T
        }

        throw IllegalArgumentException("unkonwn View Model Class")
    }
}