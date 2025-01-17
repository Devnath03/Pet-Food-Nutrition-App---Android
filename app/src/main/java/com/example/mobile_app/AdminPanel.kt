package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import android.widget.ImageView
import com.example.mobile_app.UserDB.UsersDB
import com.example.mobile_app.UserDB.Users_ViewModel
import com.example.mobile_app.UserDB.UsersViewModelFactory
import kotlinx.coroutines.launch

class AdminPanel : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var usersViewModel: Users_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_panel)

        // Initialize UI elements
        emailEditText = findViewById(R.id.txtuser)
        passwordEditText = findViewById(R.id.TxtPassword)
        loginButton = findViewById(R.id.adlogbutton)

        // Initialize the database and ViewModel
        val database = UsersDB.getInstance(this)
        val dao = database.userssdao()
        val factory = UsersViewModelFactory(dao)
        usersViewModel = ViewModelProvider(this, factory).get(Users_ViewModel::class.java)

        // Set login button click listener
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        lifecycleScope.launch {
            // Use the ViewModel's loginUser function to authenticate
            val isAuthenticated = usersViewModel.loginUser(email, password)

            if (isAuthenticated) {
                // Login successful - navigate to the next screen
                Toast.makeText(this@AdminPanel, "Login successful!,Welcome To Homepage", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@AdminPanel, UserDashboard::class.java)
                startActivity(intent)
            } else {
                // Login failed - show error message
                Toast.makeText(
                    this@AdminPanel,
                    "Login failed. Invalid credentials.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val goSignBtn = findViewById<ImageView>(R.id.goSign)
        goSignBtn.setOnClickListener {
            val intent = Intent(this, User_Info::class.java)
            startActivity(intent)

            // Show message to view Go Admin Login
            Toast.makeText(
                this,
                "Enter Your Authentication Details To Create Account",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
