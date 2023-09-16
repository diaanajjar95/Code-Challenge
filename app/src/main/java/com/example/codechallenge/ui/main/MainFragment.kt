package com.example.codechallenge.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.codechallenge.R
import com.example.codechallenge.databinding.FragmentMainBinding
import com.example.codechallenge.ui.main.dashboard.DashboardFragment
import com.example.codechallenge.ui.main.more.MoreFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMostPopularNews()

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard -> {
                    val fragmentTransaction =
                        requireActivity().supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, DashboardFragment())
                    fragmentTransaction.commit()
                    true
                }

                R.id.more -> {
                    val fragmentTransaction =
                        requireActivity().supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, MoreFragment())
                    fragmentTransaction.commit()
                    true
                }

                else -> false
            }
        }


    }

}