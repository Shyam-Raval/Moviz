package com.example.moviz.Screens

import androidx.compose.runtime.Composable
import com.example.moviz.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel : MovieViewModel) {
    // no need for observeAsState , we're no using livedata ,
    // we're using   MutableStateOf
    //ANy change in MOVIE state var , it'll trigger an automatic recomposaiotn to this 'MovieScreen'
    val moviesList = viewModel.movies
    MovieList(movies = moviesList)

}
