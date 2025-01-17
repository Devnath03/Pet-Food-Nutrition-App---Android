package com.example.mobile_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app.ProductDB.Products

class ProductsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var productsRecyclerView: RecyclerView
   // private lateinit var productsAdapter: ProductsAdapter
    private var productList: MutableList<Products> = mutableListOf()
    private lateinit var filterButton: Button
    private lateinit var filterEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        productsRecyclerView = view.findViewById(R.id.recyclerView)
        productsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample data
        productList = mutableListOf(
            Products(11, "N-Turf Canned", "Health", 400,R.drawable.dog_pol),
            Products(22, "Dry Food", "Dry",200, R.drawable.dog_giant),
            Products(33, "Dry Food", "Misc", 500,R.drawable.dog_pro)
        )

//        productsAdapter = ProductsAdapter(productList)
//        productsRecyclerView.adapter = productsAdapter

        // Filter Button and EditText
        filterButton = view.findViewById(R.id.filterButton)
        filterEditText = view.findViewById(R.id.filterEditText)

        filterButton.setOnClickListener {
            filterProducts()
        }
    }

    private fun filterProducts() {
        val query = filterEditText.text.toString().lowercase()
        val filteredProducts = productList.filter {
            it.name.lowercase().contains(query) || it.type.lowercase().contains(query)
        }
       // productsAdapter.updateProducts(filteredProducts)

        if (filteredProducts.isEmpty()) {
            Toast.makeText(requireContext(), "No products found", Toast.LENGTH_SHORT).show()
        }
    }
}


