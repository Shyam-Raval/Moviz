package com.example.moviz.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviz.Retrofit.Movie
import com.example.moviz.repository.Repository
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository): ViewModel() {
    //viewmodel : stores and manage UI related data , surviving configurations
    //view model uses mutablstate<> instead of liveData
    //when the value of "movies" changes , compose will
    // automatically recompose the parts of the ui the depend on that state
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set //only 'MovieViewModel' can change 'movies'

    //online way of getting the movie
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set
    //
    //offline movies from roomDB
    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set //only this can change from DB


    init{
        viewModelScope.launch{
              try {
                  moviesFromApi = repository
                      .getPopularMoviesFromOnlineApi("")

                  repository.insertMoviesIntoDB(moviesFromApi)
                  //assigning 'movies' to MoviesFromApi
                  movies = moviesFromApi
              }

            catch(e:Exception){
                //fetch movies  from room db
                moviesFromRoomDB = repository.getMoviesFromDB()

                movies = moviesFromRoomDB
            }
        }
    }


}