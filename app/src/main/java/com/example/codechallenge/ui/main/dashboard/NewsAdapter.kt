package com.example.codechallenge.ui.main.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.databinding.ViewItemNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsVH>() {

    private var newsList = mutableListOf<NewsEntity>()
    private lateinit var binding: ViewItemNewsBinding
    private var onItemClickListener: OnItemClickListener? = null

    fun setItems(items: List<NewsEntity>) {
        newsList.addAll(items)
        notifyItemRangeInserted(newsList.size, items.size)
    }

    fun clear() {
        newsList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        binding = ViewItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsVH(binding)
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.bind(newsList[position])

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(it, newsList[position], position)
        }

    }

    override fun getItemCount(): Int = newsList.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(view: View, item: NewsEntity, position: Int)
    }

}