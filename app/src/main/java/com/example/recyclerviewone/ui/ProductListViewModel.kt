package com.example.recyclerviewone.ui

import androidx.lifecycle.ViewModel
import com.example.recyclerviewone.data.Product
import com.example.recyclerviewone.data.getProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductListViewModel: ViewModel() {
    private var _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList: StateFlow<List<Product>> = _productList

    init {
        _productList.value = getProducts()
    }
}