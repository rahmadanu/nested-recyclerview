package com.hepipat.nestedrecyclerviewsample.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseItemViewHolder<in Any>(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root){
    var baseContext: Context? = null
    abstract fun bind(data: Any?)
}