package com.emin.repository

import com.emin.common.di.IoDispatcher
import com.emin.model.dto.MoviesDto
import com.emin.network.api.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MovieDataSource {

    override suspend fun getMovies(search: String): MoviesDto {
        return withContext(ioDispatcher){
            apiService.getMovies(searchString = search)
        }
    }
}