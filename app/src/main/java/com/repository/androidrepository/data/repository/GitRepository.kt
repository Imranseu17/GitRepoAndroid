package com.repository.androidrepository.data.repository

import com.repository.androidrepository.data.local.RepositoryDao
import com.repository.androidrepository.data.remote.RepositoryRemoteDataSource
import com.repository.androidrepository.usecase.performGetOperation
import javax.inject.Inject

class RepositoryRepository @Inject constructor(
    private val remoteDataSource: RepositoryRemoteDataSource,
    private val localDataSource: RepositoryDao
) {


    fun getRepositorys(keyword:String,sort:String) = performGetOperation(
        databaseQuery = { localDataSource.getAllRepositorys() },
        networkCall = { remoteDataSource.getRepositoryList(keyword, sort) },
        saveCallResult = { localDataSource.insertAll(it.items)})

}