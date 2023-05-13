package com.hepipat.nestedrecyclerviewsample.model

import androidx.annotation.DrawableRes

interface MovieModel

data class PopularMovieItemModel(
    val title: String,
    val listMovie: List<PopularMovieListItemModel>
): MovieModel

data class PopularMovieListItemModel(
    val title: String,
    @DrawableRes val image: Int
): MovieModel

//just in case you need to customize the top rated movie model (for example), just create a new model with new attributes/variables