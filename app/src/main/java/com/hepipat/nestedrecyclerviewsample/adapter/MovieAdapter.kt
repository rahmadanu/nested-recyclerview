package com.hepipat.nestedrecyclerviewsample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hepipat.nestedrecyclerviewsample.adapter.popular.PopularMovieViewHolder
import com.hepipat.nestedrecyclerviewsample.base.BaseRecyclerMultiTypeAdapter
import com.hepipat.nestedrecyclerviewsample.databinding.LayoutRvWithTitleAndSeemoreBinding
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieItemModel

class MovieAdapter(var context: Context) : BaseRecyclerMultiTypeAdapter<Any, RecyclerView.ViewHolder>() {

    private lateinit var layoutRvWithTitleAndSeemoreBinding: LayoutRvWithTitleAndSeemoreBinding

    private var mOnActionListener: PopularMovieViewHolder.OnActionListener? = null

    fun setOnActionListener(onActionListener: PopularMovieViewHolder.OnActionListener) {
        mOnActionListener = onActionListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_POPULAR -> {
                layoutRvWithTitleAndSeemoreBinding = LayoutRvWithTitleAndSeemoreBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                val view = PopularMovieViewHolder(layoutRvWithTitleAndSeemoreBinding)
                mOnActionListener?.let { view.setOnActionListener(it) }
                view
            }
            TYPE_TOP_RATED -> { // should be top rated viewholder
                layoutRvWithTitleAndSeemoreBinding = LayoutRvWithTitleAndSeemoreBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                val view = PopularMovieViewHolder(layoutRvWithTitleAndSeemoreBinding)
                mOnActionListener?.let { view.setOnActionListener(it) }
                view
            }
            TYPE_UPCOMING -> { // should be upcoming viewholder, it is now using the same viewholder because the data is same (only  movie title and image)
                layoutRvWithTitleAndSeemoreBinding = LayoutRvWithTitleAndSeemoreBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                val view = PopularMovieViewHolder(layoutRvWithTitleAndSeemoreBinding)
                mOnActionListener?.let { view.setOnActionListener(it) }
                view
            }
            else -> {
                throw IllegalArgumentException("Invalid ViewHolder")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val element = data[position]
        when (holder) {
            is PopularMovieViewHolder -> holder.bind(element as PopularMovieItemModel)
            //is PopularMovieViewHolder -> holder.bind(element as PopularMovieItemModel) for additional top rated/upcoming movies data
            //is PopularMovieViewHolder -> holder.bind(element as PopularMovieItemModel)
            else -> throw IllegalArgumentException()
        }
        super.onBindViewHolder(holder, position)
    }

    companion object {
        private const val TYPE_POPULAR = 0
        private const val TYPE_TOP_RATED= 1
        private const val TYPE_UPCOMING = 2
    }
}