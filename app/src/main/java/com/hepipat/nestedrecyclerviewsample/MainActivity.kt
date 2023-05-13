package com.hepipat.nestedrecyclerviewsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hepipat.nestedrecyclerviewsample.adapter.MovieAdapter
import com.hepipat.nestedrecyclerviewsample.adapter.popular.PopularMovieListItemViewHolder
import com.hepipat.nestedrecyclerviewsample.adapter.popular.PopularMovieViewHolder
import com.hepipat.nestedrecyclerviewsample.databinding.ActivityMainBinding
import com.hepipat.nestedrecyclerviewsample.model.MovieModel
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieItemModel
import com.hepipat.nestedrecyclerviewsample.model.PopularMovieListItemModel

class MainActivity : AppCompatActivity(), PopularMovieViewHolder.OnActionListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val movieAdapter by lazy { MovieAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getListMovieData()
    }

    private fun getListMovieData() {
        val listPopularMovie = arrayListOf(
            PopularMovieListItemModel("Spiderman", R.drawable.ic_launcher_background),
            PopularMovieListItemModel("Superman", R.drawable.ic_launcher_background),
            PopularMovieListItemModel("Batman", R.drawable.ic_launcher_background),
            PopularMovieListItemModel("Ironman", R.drawable.ic_launcher_background),
        )
        val popularMovie = PopularMovieItemModel("Popular Movie", listPopularMovie)
        val topRatedMovie = PopularMovieItemModel("Top Rated Movie", listPopularMovie) // just example using PopularMovieItemModel
        val upcomingMovie = PopularMovieItemModel("Upcoming", listPopularMovie) // just example using PopularMovieItemModel

        val item = arrayListOf<MovieModel>(
            popularMovie,
            topRatedMovie,
            upcomingMovie
        )

        setupRecyclerView(item)
    }

    private fun setupRecyclerView(sections: List<MovieModel>) {
        movieAdapter.clear()

        binding.rvMovies.apply {
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = movieAdapter
        }
        movieAdapter.setOnActionListener(this)
        movieAdapter.add(sections)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onSeeMoreClicked() {
        Toast.makeText(this, "User click see more", Toast.LENGTH_SHORT).show()
    }

    override fun onMovieItemClicked() {
        Toast.makeText(this, "User click list movie item", Toast.LENGTH_SHORT).show()
    }
}