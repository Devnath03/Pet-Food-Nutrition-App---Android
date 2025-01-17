package com.example.mobile_app.ProductDB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.ProductDB.Products_DAO
import kotlin.IllegalArgumentException

class ProductsViewModelFactory (

    private val dao:Products_DAO

):ViewModelProvider.Factory{

    override fun <T:ViewModel> create (modelClass:Class<T>):T{

        if(modelClass.isAssignableFrom(Products_ViewModel::class.java)){

            return Products_ViewModel(dao) as T
        }

        throw IllegalArgumentException("Unkonwn View Model Class")
    }
}