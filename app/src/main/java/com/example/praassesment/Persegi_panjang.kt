package com.example.praassesment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.praassesment.databinding.FragmentPersegiPanjangBinding

/**
 * A simple [Fragment] subclass.
 */
class Persegi_panjang : Fragment() {

    private var panjang = 0
    private var lebar = 0
    private var luas =  0
    private var keliling = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentPersegiPanjangBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_persegi_panjang,container,false)
        binding.apply {
            btnHitung.setOnClickListener {
                panjang = tvPanjang.text.toString().toInt()
                lebar = tvLebar.text.toString().toInt()
                luas = panjang * lebar
                keliling = 2 * panjang * lebar
                tvHasilLuas.text = " $luas"
                tvHasilKelilingPp.text = "$keliling"
            }
            btnSharePp.setOnClickListener{
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, "${tvHasilKelilingPp.text},${tvHasilLuas.text}")
                startActivity(shareIntent)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }


}
