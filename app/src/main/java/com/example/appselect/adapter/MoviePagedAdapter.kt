package com.example.appselect.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appselect.databinding.MovieItemBinding
import com.example.appselect.models.ResponseItem

class MoviePagedAdapter: PagingDataAdapter<ResponseItem, MoviePagedAdapter.MyViewHolder>(diffCallback) {


    inner class MyViewHolder(val binding: MovieItemBinding):
    RecyclerView.ViewHolder(binding.root)


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ResponseItem>() {

            override fun areItemsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
                //разобраться
                return oldItem.display_title == newItem.display_title
            }

            override fun areContentsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            movieTitle.text = "${currentItem?.display_title}"
            val imageLink = currentItem?.multimedia?.src
            movieImage.load(imageLink) {
                crossfade(true)
                crossfade(1000)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

}