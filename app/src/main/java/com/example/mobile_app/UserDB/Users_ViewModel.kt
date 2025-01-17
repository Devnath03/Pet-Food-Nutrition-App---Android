package com.example.mobile_app.UserDB

import androidx.lifecycle.LiveData
import com.example.mobile_app.UserDB.Users_DAO
import com.example.mobile_app.UserDB.Users
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Users_ViewModel (private val dao:Users_DAO):ViewModel(){

    val fod = dao.getalldata()

    fun insertUsers(user: Users) = viewModelScope.launch{
        dao.insertUsers(user)
    }
    fun updateUsers(user: Users) = viewModelScope.launch{
        dao.updateUser(user)
    }
    fun deleteUsers(userId: Int) = viewModelScope.launch{
        dao.deleteUser(userId)
    }
    val allUsers: LiveData<List<Users>> = dao.getalldata()


    suspend fun loginUser(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val user = dao.loginUser(email, password)
            user != null // Return true if user exists, false otherwise
        }
    }
}