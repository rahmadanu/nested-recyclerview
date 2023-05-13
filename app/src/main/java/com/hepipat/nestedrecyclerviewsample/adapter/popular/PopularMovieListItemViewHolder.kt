package com.hepipat.nestedrecyclerviewsample.adapter.popular

import com.hepipat.nestedrecyclerviewsample.base.BaseItemViewHolder
import com.hepipat.nestedrecyclerviewsample.databinding.ItemMoviePosterBinding
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieListItemModel

class PopularMovieListItemViewHolder(var binding: ItemMoviePosterBinding): BaseItemViewHolder<PopularMovieListItemModel>(binding) {

    private var mActionListener: OnActionListener? = null
    private var item: PopularMovieListItemModel? = null

    override fun bind(data: PopularMovieListItemModel?) {
        data?.let {
            item = data
            
            binding.ivPoster.setImageResource(android.R.drawable.gallery_thumb)

            binding.ivPoster.setOnClickListener {
                mActionListener?.onMovieItemClicked()
            }
        }
    }

    fun getData() : PopularMovieListItemModel?{
        return item
    }

    fun setOnActionListener(listener: OnActionListener) {
        mActionListener = listener
    }

    interface OnActionListener {
        fun onMovieItemClicked()
    }
}