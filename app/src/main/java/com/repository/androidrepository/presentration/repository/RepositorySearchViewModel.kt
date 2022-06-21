package com.repository.androidrepository.presentration.repository

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.repository.androidrepository.data.repository.RepositoryRepository

class RepositorysearchViewModel @ViewModelInject constructor(
    private val repository: RepositoryRepository
) : ViewModel() {

    val Repositorys = repository.getRepositorys("keyword:Android","stars")
}
