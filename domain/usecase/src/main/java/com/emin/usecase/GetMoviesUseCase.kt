package com.emin.usecase

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresExtension
import com.emin.common.utils.Resource
import com.emin.model.Movie
import com.emin.model.dto.toMovieList
import com.emin.repository.MovieDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetMoviesUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    @SuppressLint("SupportAnnotationUsage")
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val moviesDto = movieDataSource.getMovies(search)
            if (moviesDto.Response == "True") {
                emit(Resource.Success(moviesDto.toMovieList()))
            } else {
                emit(Resource.Error(error = Exception("No movies found")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(error = e))
        }
    }.flowOn(Dispatchers.IO)
}
