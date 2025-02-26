package com.aib.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ponycui_home.svgaplayer.databinding.ActivityFromFragmentBinding
import com.aib.fragment.AFragment
import com.aib.fragment.BFragment
import com.aib.fragment.CFragment
import com.aib.fragment.DFragment

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFromFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFromFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.vp.offscreenPageLimit = 4
        binding.vp.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 4

            override fun createFragment(position: Int): Fragment = when (position) {
                0 -> {
                    AFragment()
                }

                1 -> {
                    BFragment()
                }

                2 -> {
                    CFragment()
                }

                3 -> {
                    DFragment()
                }

                else -> {
                    DFragment()
                }
            }
        }
    }
}