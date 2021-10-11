package com.example.week5.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.R
import com.example.week5.databinding.RowDetailBinding
import com.example.week5.ui.filmlist.model.Detail

class MovieDetailsAdapter(
    private val movieDetailsList: List<Detail>
) : RecyclerView.Adapter<DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_detail,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val detail = this.movieDetailsList[position]
        holder.populate(detail)
    }

    override fun getItemCount() = this.movieDetailsList.size
}

class DetailViewHolder(private val binding : RowDetailBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(detail: Detail) {
        binding.detail = detail
        binding.executePendingBindings()
    }
}


