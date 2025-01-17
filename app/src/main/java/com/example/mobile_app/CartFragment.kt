package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_app.Cart.Carts
import com.example.mobile_app.Cart.CartDB
import com.example.mobile_app.Cart.Cart_ViewModelFactory
import com.example.mobile_app.Cart.Cart_ViewModel

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var cId: EditText
    private lateinit var cName: AutoCompleteTextView  // Update to AutoCompleteTextView
    private lateinit var cNo: EditText
    private lateinit var cMethod: EditText
    private lateinit var editTextSubtotal: EditText
    private val productPrices = hashMapOf(
        "N-Turf Canned" to 1200.50,
        "GIANT 20KG" to 4500.0,
        "Specialized Nutrition" to 450.0,
        "Dog Inova" to 600.0,
        "Royal Canin" to 500.0,
        "Diet Goat Milk Powder" to 750.0,
        "Beef Organic Vegetables" to 250.0,
        "Perfect Digestion Salmon" to 200.0,
    )

    private lateinit var viewModel: Cart_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI elements using view.findViewById
        cId = view.findViewById(R.id.editTextUserid)
        cName = view.findViewById(R.id.editTextproname) as AutoCompleteTextView
        cNo = view.findViewById(R.id.editnuproducts)
        cMethod = view.findViewById(R.id.editText)
        editTextSubtotal = view.findViewById(R.id.textViewSubtotal)

        // List of products for dropdown
        val productList = productPrices.keys.toList()

        // Set up ArrayAdapter for AutoCompleteTextView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, productList)
        cName.setAdapter(adapter)
        cName.threshold = 1

        // Update subtotal when product name or quantity changes
        cName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                updateSubtotal()
            }
        })

        cNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                updateSubtotal()
            }
        })

        // Initialize the DAO and ViewModel
        val dao = CartDB.getInstance(requireContext()).cartdao()
        val factory = Cart_ViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(Cart_ViewModel::class.java)

        // Button listeners
        view.findViewById<Button>(R.id.cartsubmit).setOnClickListener { saveCartData() }
        view.findViewById<ImageView>(R.id.imagedeletecart).setOnClickListener {
            startActivity(Intent(requireContext(), DeleteCart::class.java))
            Toast.makeText(requireContext(), "Enter Your Cart ID to Delete Cart Details", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<ImageView>(R.id.imageupdatcart).setOnClickListener {
            startActivity(Intent(requireContext(), UpdateCart::class.java))
            Toast.makeText(requireContext(), "Enter Your Cart ID to Update Cart Details", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<ImageView>(R.id.imageviewcartspre).setOnClickListener {
            startActivity(Intent(requireContext(), ViewCart::class.java))
            Toast.makeText(requireContext(), "View Your Previous Cart Details Here", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateSubtotal() {
        val productName = cName.text.toString()
        val quantityText = cNo.text.toString()

        if (productPrices.containsKey(productName) && quantityText.isNotEmpty()) {
            val pricePerUnit = productPrices[productName] ?: 0.0
            val quantity = quantityText.toIntOrNull() ?: 0
            val subtotal = pricePerUnit * quantity
            editTextSubtotal.setText(subtotal.toString())
        } else if (!productPrices.containsKey(productName)) {
            Toast.makeText(requireContext(), "Product not found", Toast.LENGTH_SHORT).show()
        } else {
            editTextSubtotal.setText("")
        }
    }

    private fun saveCartData() {
        val id = cId.text.toString().toIntOrNull()
        val name = cName.text.toString()
        val numOfItems = cNo.text.toString().toIntOrNull()
        val payMethod = cMethod.text.toString()

        if (id != null && numOfItems != null) {
            val cartItem = Carts(id, name, numOfItems, payMethod)
            viewModel.insertCarts(cartItem)
            Toast.makeText(requireContext(), "Cart data saved successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Invalid Cart ID or Number of Items", Toast.LENGTH_SHORT).show()
        }
    }
}


