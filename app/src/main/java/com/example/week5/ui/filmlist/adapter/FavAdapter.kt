package com.example.week5.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.R
import com.example.week5.databinding.RowFavBinding
import com.example.week5.ui.filmlist.model.Fav

class FavAdapter(private val favList:MutableList<Fav>): RecyclerView.Adapter<FavViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        return FavViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_fav,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderFav: FavViewHolder, position: Int) {
        val movie = this.favList[position]
        holderFav.populate(movie)
    }

    override fun getItemCount(): Int = favList.size
}

class FavViewHolder(private val binding: RowFavBinding):RecyclerView.ViewHolder(binding.root){

    fun populate(favMovie: Fav) {
        binding.fav = favMovie
        binding.executePendingBindings()
    }
}