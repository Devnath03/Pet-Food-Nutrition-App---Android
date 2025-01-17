package com.example.mobile_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.Cart.CartDB
import com.example.mobile_app.Cart.Cart_ViewModel
import com.example.mobile_app.Cart.Cart_ViewModelFactory

class DeleteCart : AppCompatActivity() {

    private lateinit var viewModel: Cart_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete_cart)

        // Set up edge-to-edge padding for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize ViewModel
        val dao = CartDB.getInstance(application).cartdao()
        val factory = Cart_ViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(Cart_ViewModel::class.java)

        // Get UI elements
        val getRemovalID = findViewById<EditText>(R.id.editTextUserid)
        val btnSubmit = findViewById<Button>(R.id.cartdelete)

        // Set up submit button click listener
        btnSubmit.setOnClickListener {
            val cartID = getRemovalID.text.toString()
            if (cartID.isNotEmpty()) {
                deleteCartData(cartID.toInt())
            } else {
                Toast.makeText(this, "Please enter a valid Cart ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to delete a cart item by ID
    private fun deleteCartData(cartID: Int) {
        // Call ViewModel to delete cart item
        viewModel.deleteCarts(cartID)
        Toast.makeText(this, "Cart deleted successfully", Toast.LENGTH_SHORT).show()
    }



}
