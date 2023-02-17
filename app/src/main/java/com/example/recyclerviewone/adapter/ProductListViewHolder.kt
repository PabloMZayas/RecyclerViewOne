package com.example.recyclerviewone.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recyclerviewone.data.Product
import com.example.recyclerviewone.databinding.LayoutProductItemBinding

    class ProductListViewHolder (
        itemBinding: LayoutProductItemBinding
    ): RecyclerView.ViewHolder(itemBinding.root){

        private val name = itemBinding.textViewProductName
        private val image = itemBinding.imageViewProduct
        private val price = itemBinding.textViewProductPrice
        private val cardViewItem = itemBinding.cardViewItem

        fun bind(product: Product, onSelectedItem: (Product)->Unit){
            name.text = product.name
            price.text = "${product.price.toString()} MXN"
            image.load(product.imageURL)
            cardViewItem.setOnClickListener { onSelectedItem(product) }
        }
    }
