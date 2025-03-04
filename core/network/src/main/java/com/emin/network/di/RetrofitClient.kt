package com.emin.network.di
/*

@Module(
    includes = [
        OkHttpClientModule::class,
    ],
)

@InstallIn(SingletonComponent::class)
object RetrofitClient {
    private const val BASE_URL = "https://api.example.com/"
    
    @Singleton
    @Provides
    fun provideRetrofitClient(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}*/