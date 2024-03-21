package com.example.gitasoulbhagavadgita.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gitasoul_bhagavadgita.R
import com.example.gitasoul_bhagavadgita.databinding.FragmentHomeBinding
import com.example.gitasoulbhagavadgita.NetworkManager
import com.example.gitasoulbhagavadgita.view.adapters.AdapterChapters
import com.example.gitasoulbhagavadgita.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapterChapters : AdapterChapters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setStatusColor()
        chechInternetConnectivity()
        return binding.root
    }

    private fun chechInternetConnectivity() {

        val networkManager = NetworkManager(requireContext())
        networkManager.observe(viewLifecycleOwner){
            if (it == true){
                binding.shimmer.visibility = View.VISIBLE
                binding.rvChapters.visibility = View.VISIBLE
                binding.tvShowingMessage.visibility = View.GONE
                getAllChapter()
            }
            else{
                binding.shimmer.visibility = View.GONE
                binding.rvChapters.visibility = View.GONE
                binding.tvShowingMessage.visibility = View.VISIBLE
            }
        }
    }

    private fun getAllChapter() {

        lifecycleScope.launch {
            viewModel.getAllChapter().collect{list ->

                adapterChapters = AdapterChapters()
                binding.rvChapters.adapter = adapterChapters
                adapterChapters.differ.submitList(list)
                binding.shimmer.visibility = View.GONE

//                for (i in list){
//                    Log.d("TAG", i.toString())
//                }
            }
        }

    }


    private fun setStatusColor() {

        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.splash)
        if (window != null) {
            WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = true
            }
        }
    }

}