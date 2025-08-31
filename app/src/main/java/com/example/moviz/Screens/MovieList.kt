package com.example.moviz.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviz.Retrofit.Movie


@Composable
fun MovieList(
    movies: List<Movie>,
    onItemClick: (Movie) -> Unit
) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(
                movie = movie,
                onItemClick = onItemClick
            )
        }
    }
}