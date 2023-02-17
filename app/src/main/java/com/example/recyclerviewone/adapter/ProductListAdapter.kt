package com.example.recyclerviewone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recyclerviewone.data.Product
import com.example.recyclerviewone.databinding.LayoutProductItemBinding

class ProductListAdapter(
    private var items: List<Product>,
    private val onSelectedItem: (Product) -> Unit
    ): RecyclerView.Adapter<ProductListViewHolder>() {

    fun submitList(productList: List<Product>){
        items = productList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            LayoutProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val product = items[position]
        holder.bind(product, onSelectedItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}