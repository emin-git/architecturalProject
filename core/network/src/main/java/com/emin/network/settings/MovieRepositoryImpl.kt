package com.emin.network.settings

import com.emin.model.dto.MoviesDto
import com.emin.network.api.ApiService
import com.emin.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(private val apiService: ApiService) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return apiService.getMovies(searchString = search)
    }
}