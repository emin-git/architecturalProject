package com.emin.repository
import com.emin.model.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search : String) : MoviesDto
}