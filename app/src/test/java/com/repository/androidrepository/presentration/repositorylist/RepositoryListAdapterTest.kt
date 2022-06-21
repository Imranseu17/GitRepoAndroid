package com.repository.androidrepository.presentration


import com.google.common.truth.Truth
import com.repository.androidrepository.models.Items
import com.repository.androidrepository.presentration.repository.RepositorySearchAdapter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class RepositoryListAdapterTest{
    @Test
    fun  whenItemIsValid(){
        val list:ArrayList<Items> = ArrayList()
        val adapter = RepositorySearchAdapter()
        val result = adapter.setItems(list)
        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun  whenItemIsInValid(){
        val list:ArrayList<Items> = arrayListOf()
        val adapter = RepositorySearchAdapter()
        val result = adapter.setItems(list)
        Truth.assertThat(result).isEqualTo(false)
    }
}