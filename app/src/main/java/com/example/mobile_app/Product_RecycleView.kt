//package com.example.mobile_app
//
//    import android.view.LayoutInflater
//    import android.view.View
//    import android.view.ViewGroup
//    import android.widget.ImageView
//    import android.widget.TextView
//    import androidx.recyclerview.widget.RecyclerView
//    import com.example.mobile_app.ProductDB.Products
//
//class ProductsAdapter(private var products: List<Products>) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
//
//        class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val productImage: ImageView = itemView.findViewById(R.id.productImage)
//            val productName: TextView = itemView.findViewById(R.id.productName)
//            val productPrice: TextView = itemView.findViewById(R.id.productPrice)
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
//            return ProductViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//            val product = products[position]
//            holder.productImage.setImageResource(product.imageResId)
//            holder.productName.text = product.name
//            holder.productPrice.text = "Rs.${product.price}"
//        }
//
//        override fun getItemCount(): Int = products.size
//
//        fun updateProducts(newProducts: List<Products>) {
//            products = newProducts
//            notifyDataSetChanged()
//        }
//    }
//
