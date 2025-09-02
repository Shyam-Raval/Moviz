package com.example.moviz.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviz.Retrofit.Movie


@Dao
interface MovieDAO {
    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movie: List<Movie>)

    @Query("Select * From movies_table")
    suspend fun getAllMoviesInDB():List<Movie>


}