package com.example.codechallenge.ui.auth.register

import android.os.Bundle
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
import com.example.codechallenge.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val fieldType = state.fieldValidation?.first
                    val error = state.fieldValidation?.second
                    when (fieldType) {
                        EnumField.FULL_NAME_FIELD -> {
                            binding.fullName.error = error
                        }

                        EnumField.EMAIL_FIELD -> {
                            binding.email.error = error
                        }

                        EnumField.NATIONAL_ID_FIELD -> {
                            binding.nationalId.error = error
                        }

                        EnumField.PHONE_NUMBER_FIELD -> {
                            binding.phoneNo.error = error
                        }

                        EnumField.DATE_OF_BIRTH_FIELD -> {
                            binding.dob.error = error
                        }

                        EnumField.PASSWORD_FIELD -> {
                            binding.password.error = error
                        }

                        null -> {

                        }
                    }

                    if (state.navigate) {
                        parentFragment?.findNavController()
                            ?.navigate(
                                R.id.action_authFragment_to_mainFragment
                            )
                    }

                    if (state.isLoading) {
                        binding.layoutProgress.root.visibility = View.VISIBLE
                    } else {
                        binding.layoutProgress.root.visibility = View.GONE
                    }
                }
            }
        }

        binding.btnregister.setOnClickListener {
            viewModel.register(
                binding.fullNameEditText.text.toString(),
                binding.emailEditText.text.toString(),
                binding.nationalIdEditText.text.toString(),
                binding.phoneNoEditText.text.toString(),
                binding.dobEditText.text.toString(),
                binding.passwordEditText.text.toString(),
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {}
    }
}