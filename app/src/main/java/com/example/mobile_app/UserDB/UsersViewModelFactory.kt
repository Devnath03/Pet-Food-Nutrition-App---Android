package com.example.mobile_app.UserDB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.IllegalArgumentException

class UsersViewModelFactory(

    private val dao: Users_DAO

):ViewModelProvider.Factory{

    override fun <T:ViewModel> create (modelClass:Class<T>):T{

        if(modelClass.isAssignableFrom(Users_ViewModel::class.java)){

            return Users_ViewModel(dao) as T
        }

        throw IllegalArgumentException("Unkonwn View Model Class")
    }
}