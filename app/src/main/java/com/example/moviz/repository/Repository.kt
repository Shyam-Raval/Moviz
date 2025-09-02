package com.example.moviz.repository

import android.content.Context
import com.example.moviz.Retrofit.Movie
import com.example.moviz.Retrofit.RetrofitInstance
import com.example.moviz.Room.MovieDAO
import com.example.moviz.Room.MoviesDB

class Repository(context:Context) {
    //getching data from online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
    //getting data from room db
    private  val db = MoviesDB.getInstance(context)
    private val movieDao : MovieDAO = db!!.moviesDao

    suspend fun getMoviesFromDB():List<Movie>{
        return movieDao.getAllMoviesInDB()
    }

    suspend fun insertMoviesIntoDB(movies:List<Movie>){
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie:Movie){
        return movieDao.insert(movie)
    }



}
