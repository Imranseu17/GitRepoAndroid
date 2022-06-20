package com.repository.androidrepository.domain

import android.content.Context
import com.repository.androidrepository.data.local.RepositoryDao
import com.repository.androidrepository.data.remote.RepositoryRemoteDataSource
import com.repository.androidrepository.data.remote.RepositoryService
import com.repository.androidrepository.data.repository.RepositoryRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    var BASE_URL = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient()
        .create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): RepositoryService = retrofit.create(RepositoryService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(RepositoryService: RepositoryService) = RepositoryRemoteDataSource(RepositoryService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        com.repository.androidrepository.data.local.AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: com.repository.androidrepository.data.local.AppDatabase) = db.RepositoryDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RepositoryRemoteDataSource,
                          localDataSource: RepositoryDao) =
        RepositoryRepository(remoteDataSource, localDataSource)




}





