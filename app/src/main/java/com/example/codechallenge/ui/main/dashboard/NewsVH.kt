package com.example.codechallenge.ui.main.dashboard


import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.databinding.ViewItemNewsBinding

class NewsVH(
    private val binding: ViewItemNewsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(newsItem: NewsEntity) {
        binding.item = newsItem
    }

}