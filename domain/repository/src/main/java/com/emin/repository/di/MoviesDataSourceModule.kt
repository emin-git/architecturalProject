package com.emin.repository.di


import com.emin.common.di.IoDispatcher
import com.emin.network.api.ApiService
import com.emin.repository.MovieDataSource
import com.emin.repository.MovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDataSourceModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(
        apiService: ApiService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): MovieDataSource {
        return MovieDataSourceImpl(apiService, ioDispatcher)
    }
}
