package com.example.codechallenge.ui.auth

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codechallenge.ui.auth.login.LoginFragment
import com.example.codechallenge.ui.auth.register.RegisterFragment

private const val NUM_TABS = 2

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return LoginFragment.newInstance()
            1 -> return RegisterFragment.newInstance()
        }
        return LoginFragment.newInstance()
    }

}