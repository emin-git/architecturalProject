package com.emin.repository.di


import com.emin.repository.MovieDataSource
import com.emin.repository.MovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMoviesSource(
        movieDataSourceImpl: MovieDataSourceImpl
    ): MovieDataSource
}