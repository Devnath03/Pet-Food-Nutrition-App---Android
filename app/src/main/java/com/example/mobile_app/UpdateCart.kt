package com.example.mobile_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.Cart.Carts
import com.example.mobile_app.Cart.CartDB
import com.example.mobile_app.Cart.Cart_ViewModel
import com.example.mobile_app.Cart.Cart_ViewModelFactory

class UpdateCart : AppCompatActivity() {

    private lateinit var viewModel: Cart_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dao = CartDB.getInstance(application).cartdao()
        val factory = Cart_ViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(Cart_ViewModel::class.java)

        // Call the function to set up the update button functionality
        updateCartData()
    }

    private fun updateCartData() {
        val upId = findViewById<EditText>(R.id.editTextUserid1)
        val upName = findViewById<EditText>(R.id.editTextproname1)
        val upitems = findViewById<EditText>(R.id.editnuproducts1)
        val upmethod = findViewById<EditText>(R.id.edittext1)
        val updateBtn = findViewById<Button>(R.id.cartupdate)

        updateBtn.setOnClickListener {
            try {
                // Get values from EditText fields on button click
                val cDid = upId.text.toString().toInt()
                val productname = upName.text.toString()
                val noofproducts = upitems.text.toString().toInt()
                val paymethod = upmethod.text.toString()

                // Create a Cart object with updated values
                val updatedCart = Carts(Cid = cDid, CName = productname, Citems = noofproducts, Cpayment = paymethod)

                // Update drug in database using ViewModel
                viewModel.updateCarts(updatedCart)



            } catch (e: NumberFormatException) {
                // Handle possible parsing errors
                upId.error = "Please enter a valid ID and Price"
            }
        }
    }
}

