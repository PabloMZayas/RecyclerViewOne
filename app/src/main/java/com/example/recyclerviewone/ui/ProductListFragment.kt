package com.example.recyclerviewone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewone.R
import com.example.recyclerviewone.adapter.ProductListAdapter
import com.example.recyclerviewone.data.Product
import com.example.recyclerviewone.databinding.FragmentProductListBinding

class ProductListFragment : Fragment(){
    private var _binding : FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = ProductListAdapter(viewModel.productList.value) {onSelectedItem (it)}

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = rvAdapter
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.productList.collect{
                rvAdapter.submitList(it)
            }
        }
    }

    private fun onSelectedItem(product: Product) {
        val bundle = Bundle()
        bundle.putParcelable("product", product)
        findNavController().navigate(R.id.action_productListFragment_to_detailProductFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}