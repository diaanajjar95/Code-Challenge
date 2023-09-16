package com.example.codechallenge.ui.main.more

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.codechallenge.R
import com.example.codechallenge.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val TAG = "MoreFragment"

@AndroidEntryPoint
class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private val viewModel: MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    if (state.isLoggedOut) {
                        parentFragment?.findNavController()
                            ?.navigate(R.id.action_mainFragment_to_authFragment)
                    }

                    state.user?.let {
                        binding.user = it
                    } ?: kotlin.run {
                        Log.d(TAG, "onViewCreated: user is null")
                    }

                    if (state.isLoading) {
                        binding.layoutProgress.root.visibility = View.VISIBLE
                    } else {
                        binding.layoutProgress.root.visibility = View.GONE
                    }
                }
            }
        }

        binding.logoutTv.setOnClickListener {
            viewModel.logout()
        }

        viewModel.fetchUser()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MoreFragment().apply {}
    }
}