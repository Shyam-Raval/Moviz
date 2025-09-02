package com.example.moviz.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.moviz.Retrofit.Movie





@Composable
fun MovieList(movies:List<Movie>) {
    LazyColumn{
        items(movies){
                movie -> MovieItem(movie)

        }
    }
}


