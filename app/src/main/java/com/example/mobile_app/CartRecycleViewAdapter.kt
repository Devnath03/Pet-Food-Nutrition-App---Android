package com.example.mobile_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app.Cart.Carts

class CartRecycleViewAdapter(private val CartList: List<Carts>) : RecyclerView.Adapter<CartRecycleViewAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName) // Change to your layout's TextView ID
        val nameTextView1: TextView = itemView.findViewById(R.id.tvName1)
        val nameTextView2: TextView = itemView.findViewById(R.id.tvName2)
        val nameTextView3: TextView = itemView.findViewById(R.id.tvName3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false) // Create a layout for each customer
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = CartList[position]
        holder.nameTextView.id = cart.Cid
        holder.nameTextView1.text = cart.CName
        holder.nameTextView2.id = cart.Citems
        holder.nameTextView3.text = cart.Cpayment// Change to your property name
    }

    override fun getItemCount(): Int {
        return CartList.size
    }
}


