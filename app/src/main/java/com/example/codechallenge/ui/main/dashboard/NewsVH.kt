package com.example.codechallenge.ui.main.dashboard


import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.databinding.ViewItemNewsBinding
import com.example.codechallenge.utils.calculateTimeAgo

class NewsVH(
    private val binding: ViewItemNewsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(newsItem: NewsEntity) {
        newsItem.publishedDate = newsItem.publishedDate?.calculateTimeAgo()
        binding.item = newsItem
    }

}