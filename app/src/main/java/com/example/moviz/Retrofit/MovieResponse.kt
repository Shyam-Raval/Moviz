package com.example.moviz.Retrofit

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class MovieResponse(
    //always make data field same
    val pages:Int ,
    val results: List<Movie>,
    @SerializedName("total_pages") //when we don't wanna use the name given in json
    val totalPages:Int ,
    val total_results:Int
)