package com.hepipat.nestedrecyclerviewsample.adapter.popular

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.hepipat.nestedrecyclerviewsample.R
import com.hepipat.nestedrecyclerviewsample.base.BaseItemViewHolder
import com.hepipat.nestedrecyclerviewsample.databinding.LayoutRvWithTitleAndSeemoreBinding
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieItemModel

class PopularMovieViewHolder(var binding: LayoutRvWithTitleAndSeemoreBinding)
    : BaseItemViewHolder<PopularMovieItemModel>(binding), PopularMovieListItemViewHolder.OnActionListener{

    private var item: PopularMovieItemModel? = null
    private val popularMovieListItemAdapter: PopularMovieListItemAdapter? = PopularMovieListItemAdapter(binding.root.context)

    private var mActionListener: OnActionListener? = null

    fun setOnActionListener(listener: OnActionListener) {
        mActionListener = listener
    }

    override fun bind(data: PopularMovieItemModel?) {
        data?.let {
            item = data

            binding.rvPoster.apply {
                setHasFixedSize(false)
                isNestedScrollingEnabled = false
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = popularMovieListItemAdapter
            }
            popularMovieListItemAdapter?.add(data.listMovie)
            binding.rvPoster.visibility = View.VISIBLE
            binding.tvTitle.text = data.title

            binding.tvSeeMore.setOnClickListener {
                mActionListener?.onSeeMoreClicked()
            }

            popularMovieListItemAdapter?.setOnActionListener(this)
        }
    }

    /*fun getTitleView(): TextView {
        return binding.textViewMenuTitle
    }*/

    fun getData() : PopularMovieItemModel?{
        return item
    }

    interface OnActionListener {
        fun onSeeMoreClicked()
        fun onMovieItemClicked()
    }

    override fun onMovieItemClicked() {
        mActionListener?.onMovieItemClicked()
    }
}