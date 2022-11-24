package com.example.dbreference.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.bekzod.dbreferenses.R
import developer.bekzod.dbreferenses.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnSotuvchi.setOnClickListener {
            findNavController().navigate(R.id.sotuvFragment)
        }
        binding.btnXaridor.setOnClickListener {
            findNavController().navigate(R.id.xaridFragment)
        }
        binding.btnBuyurtma.setOnClickListener{
            findNavController().navigate(R.id.buyurtmaFragment)
        }
        return binding.root
    }
}

