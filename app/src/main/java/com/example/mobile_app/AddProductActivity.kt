//package com.example.mobile_app
//
//import android.app.AlertDialog
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class AddProductActivity : AppCompatActivity() {
//
//    private lateinit var productImageView: ImageView
//    private lateinit var productNameEditText: EditText
//    private lateinit var productPriceEditText: EditText
//    private lateinit var productDescriptionEditText: EditText
//    private val products = ArrayList<String>() // List to hold product details
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_product)
//
//        // Initialize UI components
//        productImageView = findViewById(R.id.productImageView)
//        productNameEditText = findViewById(R.id.productNameEditText)
//        productPriceEditText = findViewById(R.id.productPriceEditText)
//        productDescriptionEditText = findViewById(R.id.productDescriptionEditText)
//
//        // Set up button to select image from drawable resources
//        findViewById<Button>(R.id.selectImageButton).setOnClickListener {
//            showImageSelectionDialog()
//        }
//
//        // Set up save button to insert product into the product list
//        findViewById<Button>(R.id.saveProductButton).setOnClickListener {
//            saveProduct()
//        }
//    }
//
//    private fun showImageSelectionDialog() {
//        val imageResIds = arrayOf(
//            R.drawable.product_image2,
//            R.drawable.product_image,
//            R.drawable.dog_giant,
//            R.drawable.dog_inova,
//            R.drawable.dog_meat,
//            R.drawable.dog_milk
//        )
//
//        val imageNames = imageResIds.map { resources.getResourceEntryName(it) }.toTypedArray()
//
//        AlertDialog.Builder(this)
//            .setTitle("Select an Image")
//            .setItems(imageNames) { _, which ->
//                val selectedImageResId = imageResIds[which]
//                productImageView.setImageResource(selectedImageResId)
//                Toast.makeText(this, "Selected: ${imageNames[which]}", Toast.LENGTH_SHORT).show()
//            }
//            .show()
//    }
//
//    private fun saveProduct() {
//        val name = productNameEditText.text.toString()
//        val price = productPriceEditText.text.toString()
//        val description = productDescriptionEditText.text.toString()
//
//        if (name.isEmpty() || price.isEmpty() || description.isEmpty()) {
//            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val productDetails = "$name - $$price" // Formatting product details for display
//        products.add(productDetails) // Add the current product to the list
//        clearFields()
//
//        // Create Intent to start ProductListActivity
//        val intent = Intent(this, ProductList::class.java)
//        intent.putStringArrayListExtra("PRODUCT_LIST", products) // Pass the product list
//        startActivity(intent) // Start ProductListActivity
//    }
//
//    private fun clearFields() {
//        productNameEditText.text.clear()
//        productPriceEditText.text.clear()
//        productDescriptionEditText.text.clear()
//        productImageView.setImageResource(0) // Clear image
//    }
//}
//
////package com.example.mobile_app
////
////import android.app.AlertDialog
////import android.os.Bundle
////import android.widget.Button
////import android.widget.EditText
////import android.widget.ImageView
////import android.widget.Toast
////import androidx.appcompat.app.AppCompatActivity
////
////class AddProductActivity : AppCompatActivity() {
////
////    private lateinit var productImageView: ImageView
////    private lateinit var productNameEditText: EditText
////    private lateinit var productPriceEditText: EditText
////    private lateinit var productDescriptionEditText: EditText
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_add_product)
////
////        // Initialize UI components
////        productImageView = findViewById(R.id.productImageView)
////        productNameEditText = findViewById(R.id.productNameEditText)
////        productPriceEditText = findViewById(R.id.productPriceEditText)
////        productDescriptionEditText = findViewById(R.id.productDescriptionEditText)
////
////        // Set up button to select image from drawable resources
////        findViewById<Button>(R.id.selectImageButton).setOnClickListener {
////            showImageSelectionDialog()
////        }
////
////        // Set up the save button functionality here if needed
////    }
////
////    private fun showImageSelectionDialog() {
////        // Array of drawable image resource IDs
////        val imageResIds = arrayOf(
////            R.drawable.product_image2,  // Replace with actual image names in drawable
////            R.drawable.product_image,
////            R.drawable.dog_giant,
////            R.drawable.dog_inova,
////            R.drawable.dog_meat,
////            R.drawable.dog_milk
////        )
////
////        // Convert resource IDs to drawable names for dialog
////        val imageNames = imageResIds.map { resources.getResourceEntryName(it) }.toTypedArray()
////
////        // Show AlertDialog to choose an image
////        AlertDialog.Builder(this)
////            .setTitle("Select an Image")
////            .setItems(imageNames) { _, which ->
////                // Set selected image in ImageView
////                val selectedImageResId = imageResIds[which]
////                productImageView.setImageResource(selectedImageResId)
////                Toast.makeText(this, "Selected: ${imageNames[which]}", Toast.LENGTH_SHORT).show()
////            }
////            .show()
////    }
////}
//
////package com.example.mobile_app
////
////import android.app.Activity
////import android.content.Intent
////import android.net.Uri
////import android.os.Bundle
////import android.widget.*
////import androidx.activity.result.contract.ActivityResultContracts
////import androidx.appcompat.app.AppCompatActivity
////import androidx.lifecycle.lifecycleScope
////import com.example.mobile_app.DogProducts.Product
////import com.example.mobile_app.DogProducts.ProductDatabase
////import kotlinx.coroutines.launch
////
////class AddProductActivity : AppCompatActivity() {
////
////    private lateinit var productImageView: ImageView
////    private lateinit var productNameEditText: EditText
////    private lateinit var productPriceEditText: EditText
////    private lateinit var productDescriptionEditText: EditText
////    private var imageUri: Uri? = null
////
////    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
////        uri?.let {
////            imageUri = it
////            productImageView.setImageURI(it)
////        }
////    }
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_add_product)
////
////        // Initialize UI components
////        productImageView = findViewById(R.id.productImageView)
////        productNameEditText = findViewById(R.id.productNameEditText)
////        productPriceEditText = findViewById(R.id.productPriceEditText)
////        productDescriptionEditText = findViewById(R.id.productDescriptionEditText)
////
////        findViewById<Button>(R.id.selectImageButton).setOnClickListener {
////            selectImageLauncher.launch("image/*")
////        }
////
////        findViewById<Button>(R.id.saveProductButton).setOnClickListener {
////            saveProduct()
////        }
////    }
////
////    private fun saveProduct() {
////        val name = productNameEditText.text.toString()
////        val price = productPriceEditText.text.toString().toDoubleOrNull()
////        val description = productDescriptionEditText.text.toString()
////
////        if (name.isEmpty() || price == null || description.isEmpty() || imageUri == null) {
////            Toast.makeText(this, "Please fill all fields and select an image", Toast.LENGTH_SHORT).show()
////            return
////        }
////
////        val product = Product(
////            name = name,
////            price = price,
////            description = description,
////            imageUri = imageUri.toString()
////        )
////
////        lifecycleScope.launch {
////            ProductDatabase.getDatabase(applicationContext).productDao().addProduct(product)
////            Toast.makeText(this@AddProductActivity, "Product saved!", Toast.LENGTH_SHORT).show()
////            finish() // Close activity after saving
////        }
////    }
////}
//
//
////package com.example.mobile_app
////
////import android.os.Bundle
////import androidx.activity.enableEdgeToEdge
////import androidx.appcompat.app.AppCompatActivity
////import androidx.core.view.ViewCompat
////import androidx.core.view.WindowInsetsCompat
////
////class AddProductActivity : AppCompatActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        enableEdgeToEdge()
////        setContentView(R.layout.activity_add_product)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
////    }
////}