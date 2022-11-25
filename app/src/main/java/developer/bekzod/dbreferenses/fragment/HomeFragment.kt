package developer.bekzod.dbreferenses.fragment

import android.annotation.SuppressLint
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

    @SuppressLint("ResourceType")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnSotuvchiQoshish.setOnClickListener {
            findNavController().navigate(R.id.sotuvFragment)
        }
        binding.btnXaridorQoshish.setOnClickListener {
            findNavController().navigate(R.id.xaridFragment)
        }
        binding.btnBuyurtmaBerish.setOnClickListener{
            findNavController().navigate(R.id.buyurtmaFragment)
        }
        return binding.root
    }
}

