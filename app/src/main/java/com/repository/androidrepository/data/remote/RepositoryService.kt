package com.repository.androidrepository.data.remote



import com.repository.androidrepository.models.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RepositoryService {

    @Headers( "Content-Type: application/json; charset=utf-8" )
    @GET("repositories")
    suspend fun getAllRepositorys(@Query("q") keyword:String,
                             @Query("sort") sort:String)
    :Response<Root>


}