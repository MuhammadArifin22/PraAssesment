package com.example.praassesment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.praassesment.databinding.FragmentPersegiPanjangBinding
import com.example.praassesment.databinding.FragmentSegitigaBinding
import kotlinx.android.synthetic.main.fragment_segitiga.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * A simple [Fragment] subclass.
 */
class Segitiga : Fragment() {


    private var alas:Int = 0
    private var tinggi:Int = 0
    private var luas : Double = 0.0
    private var keliling: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSegitigaBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_segitiga,container,false)
        binding.apply {
            btnHitungSegitiga.setOnClickListener {
                alas = tv_alas.text.toString().toInt()
                tinggi = tv_tinggi.text.toString().toInt()
                luas = 0.5 * alas * tinggi
                keliling = alas + tinggi + (sqrt(alas.toDouble().pow(2)+tinggi.toDouble().pow(2)))

                tv_hasil_luas_segitiga.text = " $luas"
                tv_hasil_keliling_segitiga.text = "$keliling"
            }
            btnShareSegitiga.setOnClickListener{
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, "${tvHasilLuasSegitiga.text},${tvHasilKelilingSegitiga.text}")
                startActivity(shareIntent)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}

