package com.repository.androidrepository.data.remote

import android.util.Log
import com.repository.androidrepository.usecase.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                Log.e("Data: ",""+body)
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }


    private fun <T> error(message: String): Resource<T> {
        Log.e("error: ",message)
        return Resource.error(message)
    }

}