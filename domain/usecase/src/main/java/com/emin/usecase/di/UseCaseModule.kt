package com.emin.usecase.di

import com.emin.repository.MovieDataSource
import com.emin.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(movieDataSource: MovieDataSource): GetMoviesUseCase {
        return GetMoviesUseCase(movieDataSource)
    }
}
