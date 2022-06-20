package com.repository.androidrepository.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.repository.androidrepository.models.Items


@Dao
interface RepositoryDao {

    @Query("SELECT * FROM items")
    fun getAllRepositorys() : LiveData<List<Items>>

    @Query("SELECT * FROM items WHERE id = :id")
    fun getRepository(id: String): LiveData<Items>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(Repository: List<Items>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(Repository: List<Items>?)


}