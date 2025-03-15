package com.emin.repository

import com.emin.model.dto.MoviesDto

interface MovieDataSource {

    suspend fun getMovies(search : String) : MoviesDto

}