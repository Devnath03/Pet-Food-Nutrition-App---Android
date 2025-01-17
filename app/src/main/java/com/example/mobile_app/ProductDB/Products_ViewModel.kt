package com.example.mobile_app.ProductDB

import com.example.mobile_app.ProductDB.Products_DAO
import com.example.mobile_app.ProductDB.Products
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch


class Products_ViewModel (private val dao:Products_DAO):ViewModel(){

    val fob = dao.getalldata()

    fun insertProducts (product: Products) = viewModelScope.launch{
        dao.insertProducts(product)
    }
//    fun updateDrugs(drug: Drugs) = viewModelScope.launch{
//        dao.updateDrugs(drug)
//    }
//    fun deleteDrugs(drugId: Int) = viewModelScope.launch{
//        dao.deleteDrugs(drugId)
//    }

}