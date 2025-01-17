package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.UserDB.Users
import com.example.mobile_app.UserDB.UsersDB
import com.example.mobile_app.UserDB.UsersViewModelFactory
import com.example.mobile_app.UserDB.Users_ViewModel


class User_Info : AppCompatActivity() {

    private lateinit var dDId: EditText
    private lateinit var dDUsername: EditText
    private lateinit var dDUseremail: EditText
    private lateinit var dDUserAge: EditText
    private lateinit var dDUserPetname: EditText
    private lateinit var dDUserPassword: EditText

    private lateinit var viewModel: Users_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dDId=findViewById(R.id.editTextUserid)
        dDUsername =findViewById(R.id.editTextUsername)
        dDUseremail=findViewById(R.id.editTextEmail)
        dDUserAge=findViewById(R.id.editTextAge)
        dDUserPetname=findViewById(R.id.editTextPayMethod)
        dDUserPassword=findViewById(R.id.editTextPassword)

        val btnsign=findViewById<Button>(R.id.buttonsign)
        val dao= UsersDB.getInstance(application).userssdao()
        val factory= UsersViewModelFactory(dao)

        viewModel= ViewModelProvider(this,factory).get(Users_ViewModel::class.java)

        btnsign.setOnClickListener{
            saveUserData()
        }
        val GoLogBtn = findViewById<ImageView>(R.id.movelog)

        GoLogBtn.setOnClickListener{
            val intent = Intent(this, AdminPanel::class.java)
            startActivity(intent)
            // Show message to view Go Admin Login
            Toast.makeText(this, "Please Enter Your Login Details", Toast.LENGTH_SHORT).show()

        }
    }
    private fun saveUserData(){

        val dId=dDId.text.toString().toInt()
        val dName=dDUsername.text.toString()
        val dEmail=dDUseremail.text.toString()
        val dAge=dDUserAge.text.toString().toInt()
        val dPetname=dDUserPetname.text.toString()
        val dPassword=dDUserPassword.text.toString().toInt()

        val user= Users(dId,dName,dEmail,dAge,dPetname,dPassword)
        viewModel.insertUsers(user)

        // Show message to view Go Admin Login
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

    }
}

