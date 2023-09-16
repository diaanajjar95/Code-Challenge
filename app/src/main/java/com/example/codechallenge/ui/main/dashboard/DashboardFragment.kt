package com.example.codechallenge.ui.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.codechallenge.R
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.databinding.FragmentDashboardBinding
import com.example.codechallenge.ui.base.generic.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()
    private val newsAdapter: NewsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = newsAdapter
            val spaceInPixels = resources.getDimensionPixelSize(R.dimen.dim_8dp)
            addItemDecoration(SpaceItemDecoration(spaceInPixels))
        }

        newsAdapter.setOnItemClickListener(object :
            NewsAdapter.OnItemClickListener {
            override fun onItemClicked(view: View, item: NewsEntity, position: Int) {
                Toast.makeText(requireContext(), "clicked on ${item.title}", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { dashboardUiState ->

                    if (!dashboardUiState.newsList.isNullOrEmpty()) {
                        newsAdapter.clear()
                        newsAdapter.setItems(dashboardUiState.newsList)
                    }

                    dashboardUiState.message?.let { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                        viewModel.messageShown()
                    }

                    if (dashboardUiState.isLoading) {
                        binding.layoutProgress.root.visibility = View.VISIBLE
                    } else {
                        binding.layoutProgress.root.visibility = View.GONE
                    }
                }
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DashboardFragment().apply {}
    }
}