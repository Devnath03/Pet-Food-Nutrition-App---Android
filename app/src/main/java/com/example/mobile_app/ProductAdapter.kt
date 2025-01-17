//package com.example.mobile_app
//
//import android.R
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class ProductAdapter(
//    private val productList: List<Product>,
//    private val listener: OnItemClickListener
//) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
//
//    interface OnItemClickListener {
//        fun onAddToCart(product: Product?)
//        fun onRemoveFromCart(product: Product?)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
//        return ProductViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        val product: Product = productList[position]
//        holder.bind(product, listener)
//    }
//
//    override fun getItemCount(): Int {
//        return productList.size
//    }
//
//    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private var productName: TextView = itemView.findViewById(R.id.product_name)
//        private var productPrice: TextView = itemView.findViewById(R.id.product_price)
//        private var productQuantity: TextView = itemView.findViewById(R.id.product_quantity)
//        private var addButton: Button = itemView.findViewById(R.id.add_button)
//        private var removeButton: Button = itemView.findViewById(R.id.remove_button)
//
//        fun bind(product: Product, listener: OnItemClickListener) {
//            productName.text = product.getName()
//            productPrice.text = "Price: Rs. " + product.getPrice()
//            productQuantity.text = "Quantity: " + product.getQuantity()
//
//            addButton.setOnClickListener {
//                product.setQuantity(product.getQuantity() + 1)
//                productQuantity.text = "Quantity: " + product.getQuantity()
//                listener.onAddToCart(product)
//            }
//
//            removeButton.setOnClickListener {
//                if (product.getQuantity() > 0) {
//                    product.setQuantity(product.getQuantity() - 1)
//                    productQuantity.text = "Quantity: " + product.getQuantity()
//                    listener.onRemoveFromCart(product)
//                }
//            }
//        }
//    }
//}
