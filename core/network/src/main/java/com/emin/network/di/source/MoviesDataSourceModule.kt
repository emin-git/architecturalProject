package com.emin.network.di.source

import com.emin.network.data.MovieDataSource
import com.emin.network.data.MovieDataSourceImpl
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
    internal abstract fun bindMoviesSource(
        movieDataSourceImpl: MovieDataSourceImpl
    ): MovieDataSource
}