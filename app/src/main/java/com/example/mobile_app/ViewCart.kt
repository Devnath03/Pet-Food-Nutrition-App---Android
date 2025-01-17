package com.example.mobile_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import  androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app.Cart.CartDB
import com.example.mobile_app.Cart.Cart_ViewModel
import com.example.mobile_app.Cart.Cart_ViewModelFactory


class ViewCart : AppCompatActivity() {

    private lateinit var viewModel:Cart_ViewModel
    //    private lateinit var recyclerView:MyRecycleViewAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_cart)
        val dao = CartDB.getInstance(application).cartdao()
        val factory = Cart_ViewModelFactory(dao)
        viewModel = ViewModelProvider(this,factory).get(Cart_ViewModel::class.java)


        recyclerView = findViewById(R.id.recycleviewlist)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        // observe the livedata from the vir=ew model
        viewModel.allcarts.observe(this,Observer {drugs ->
            // update the recycleview with the customer list
            recyclerView.adapter =  CartRecycleViewAdapter(drugs)
        })


    }
}
