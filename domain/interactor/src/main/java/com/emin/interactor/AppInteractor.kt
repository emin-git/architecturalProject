package com.emin.interactor
import com.emin.repository.MovieRepository
import com.emin.usecase.GetMoviesUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppInteractor @Inject constructor(repository: MovieRepository) {
    val getExamples = GetMoviesUseCase(repository)
}