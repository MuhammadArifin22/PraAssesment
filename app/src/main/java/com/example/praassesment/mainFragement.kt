package com.example.praassesment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.praassesment.databinding.FragmentMainFragementBinding
import kotlinx.android.synthetic.main.fragment_main_fragement.*

/**
 * A simple [Fragment] subclass.
 */
class mainFragement : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentMainFragementBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_fragement,container,false)
        binding.apply {
            btnPp.setOnClickListener{v: View ->
                v.findNavController().navigate(mainFragementDirections.actionMainFragementToPersegiPanjang2())
            }
            btnSegitiga.setOnClickListener{v: View ->
                v.findNavController().navigate(mainFragementDirections.actionMainFragementToSegitiga2())
            }
        }
       setHasOptionsMenu(true)
        return binding.root
    }
}
