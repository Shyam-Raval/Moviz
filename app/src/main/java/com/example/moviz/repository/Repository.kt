package com.example.moviz.repository

import com.example.moviz.Retrofit.Movie
import com.example.moviz.Retrofit.RetrofitInstance

class Repository {
    //getching data from online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}