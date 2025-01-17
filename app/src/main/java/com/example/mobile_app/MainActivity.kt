package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val GOADBtn = findViewById<ImageButton>(R.id.RightButton)

        GOADBtn.setOnClickListener{
            val intent = Intent(this, AdminPanel::class.java)
            startActivity(intent)

            // Show message to view Go Login
            Toast.makeText(this, "Welcome U To Dog Nutrition ", Toast.LENGTH_SHORT).show()

        }
    }
}