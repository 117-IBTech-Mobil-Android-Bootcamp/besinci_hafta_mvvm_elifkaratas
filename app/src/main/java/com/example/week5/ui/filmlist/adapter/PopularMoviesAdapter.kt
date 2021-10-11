package com.example.week5.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.week3.BaseRecyclerViewItemClickListener
import com.example.week5.R
import com.example.week5.databinding.RowPopularBinding
import com.example.week5.ui.filmlist.model.Popular

class PopularMoviesAdapter(
    private val popularMoviesList: List<Popular>
) : RecyclerView.Adapter<PopularViewHolder>() {

    private lateinit var itemClickListener: BaseRecyclerViewItemClickListener<Popular>

    constructor(
        popularMoviesList: MutableList<Popular>,
        itemClickListener: BaseRecyclerViewItemClickListener<Popular>
    ) : this(popularMoviesList)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_popular,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular = this.popularMoviesList[position]
        holder.populate(popular)
        //holder.setOnClickListener(popular, this.itemClickListener)
    }

    override fun getItemCount() = this.popularMoviesList.size
}

class PopularViewHolder(private val binding : RowPopularBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(popular: Popular) {
        binding.popular = popular
        binding.executePendingBindings()
    }

    fun setOnClickListener(
        popular: Popular,
        itemClickListener: BaseRecyclerViewItemClickListener<Popular>
    ) {
        binding.root.setOnClickListener {
            itemClickListener.onItemClicked(popular, it.id)
        }
    }
}


