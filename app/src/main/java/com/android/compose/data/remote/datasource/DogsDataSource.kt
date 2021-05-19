package com.android.compose.data.remote.datasource

import com.android.compose.data.remote.entities.DogsResponse
import retrofit2.Response


interface DogsDataSource {
    suspend fun fetchDogsList(dogType: String): Response<DogsResponse>
}