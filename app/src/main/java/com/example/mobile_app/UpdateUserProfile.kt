package com.example.mobile_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.UserDB.Users
import com.example.mobile_app.UserDB.UsersDB
import com.example.mobile_app.UserDB.UsersViewModelFactory
import com.example.mobile_app.UserDB.Users_ViewModel

class UpdateUserProfile : AppCompatActivity() {

    private lateinit var viewModel: Users_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_user_profile)
        val dao = UsersDB.getInstance(application).userssdao()
        val factory = UsersViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(Users_ViewModel::class.java)

        // Call the function to set up the update button functionality
        updateUserData()
    }

    private fun updateUserData() {
        val upId = findViewById<EditText>(R.id.editupTextUserid)
        val upName = findViewById<EditText>(R.id.editupTextUsername)
        val upemail = findViewById<EditText>(R.id.editupTextEmail)
        val upAge = findViewById<EditText>(R.id.editupTextAge)
        val upPay = findViewById<EditText>(R.id.editupTextPayMathod)
        val upPass = findViewById<EditText>(R.id.editupTextPassword)
        val updateBtn = findViewById<Button>(R.id.buttonupsign)

        updateBtn.setOnClickListener {
            try {
                // Get values from EditText fields on button click
                val cDid = upId.text.toString().toInt()
                val UName = upName.text.toString()
                val Uemail = upemail.text.toString()
                val UAge = upAge.text.toString().toInt()
                val UPay = upPay.text.toString()
                val UPass = upPass.text.toString().toInt()

                // Create a User object with updated values
                val updatedUser = Users(Did = cDid, Username = UName, Email = Uemail, Age = UAge, PetName = UPay, Password = UPass)

                // Update user in database using ViewModel
                viewModel.updateUsers(updatedUser)

                // Show message to view Go Admin Login
                Toast.makeText(this, "Updated Successfully, Please Enter Your Login Details", Toast.LENGTH_SHORT).show()


                // Navigate back to the Home activity
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
                finish() // Optional: finish the current activity

            } catch (e: NumberFormatException) {
                // Handle possible parsing errors
                upId.error = "Please enter a valid ID and Price"
            }
        }
    }
}
