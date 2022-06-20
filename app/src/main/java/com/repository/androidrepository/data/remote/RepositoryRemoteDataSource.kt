package com.repository.androidrepository.data.remote

import javax.inject.Inject

class RepositoryRemoteDataSource @Inject constructor(
    private val RepositoryService: RepositoryService
): BaseDataSource() {

    suspend fun getRepositoryList(keyword:String,sort:String) =
        getResult { RepositoryService.getAllRepositorys(keyword, sort) }

}