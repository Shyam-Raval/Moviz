package com.example.moviz.Screens

import androidx.compose.runtime.Composable
import com.example.moviz.viewmodel.MovieViewModel
// In your screen file where MovieScreen is defined
// Make sure to import android.util.Log

import android.util.Log
// ... other imports

@Composable
fun MovieScreen(viewModel: MovieViewModel) {
    val moviesList = viewModel.movies

    MovieList(
        movies = moviesList,
        onItemClick = { movie ->
            // This is where you would navigate to a detail screen, for example.
            // For now, we'll just log the title.
            Log.d("MovieScreen", "Clicked on movie: ${movie.title}")
        }
    )
}