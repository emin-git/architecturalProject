package com.emin.network.api

import com.emin.model.dto.MoviesDto
import com.emin.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString :String,
        @Query("apikey") apiKey :String = API_KEY
    ) : MoviesDto
}