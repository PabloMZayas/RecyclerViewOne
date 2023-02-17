package com.example.recyclerviewone.ui

import android.annotation.SuppressLint
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_NONE
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import coil.load
import com.example.recyclerviewone.data.Product
import com.example.recyclerviewone.databinding.FragmentDetailProductBinding

class DetailProductFragment : Fragment(){
    private var _binding : FragmentDetailProductBinding? = null
    private val binding get() = _binding!!
    //private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product: Product = requireArguments().getParcelable("product")!!
        setDataLayout(product)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun setDataLayout(product: Product) {
        with (binding){
            tvNameProduct.text = product.name
            tvProductPrice.text = "$ MXN ${product.price}"
            ivProductImage.load(product.imageURL)
            tvProductDescription.justificationMode = JUSTIFICATION_MODE_NONE
            tvProductDescription.text = product.description
            tvProductId.text = "Id: ${product.id}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}