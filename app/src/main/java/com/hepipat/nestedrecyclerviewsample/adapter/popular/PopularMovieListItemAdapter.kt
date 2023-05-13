package com.hepipat.nestedrecyclerviewsample.adapter.popular

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hepipat.nestedrecyclerviewsample.base.BaseRecyclerAdapter
import com.hepipat.nestedrecyclerviewsample.databinding.ItemMoviePosterBinding
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieListItemModel

class PopularMovieListItemAdapter(var context: Context?) : BaseRecyclerAdapter<PopularMovieListItemModel, PopularMovieListItemViewHolder>() {

    private lateinit var itemMoviePosterBinding: ItemMoviePosterBinding
    private var mOnActionListener: PopularMovieListItemViewHolder.OnActionListener? = null

    fun setOnActionListener(onActionListener: PopularMovieListItemViewHolder.OnActionListener) {
        mOnActionListener = onActionListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieListItemViewHolder {
        itemMoviePosterBinding =
            ItemMoviePosterBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = PopularMovieListItemViewHolder(itemMoviePosterBinding)
        mOnActionListener?.let { view.setOnActionListener(it) }
        return view
    }

    override fun onBindViewHolder(holder: PopularMovieListItemViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }

}