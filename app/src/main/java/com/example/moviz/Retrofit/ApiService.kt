package com.example.moviz.Retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    //each method in Api Service in API call
    @GET("movie/popular") //endpoint
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String

    ):MovieResponse


}