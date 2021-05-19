package com.android.compose.data.remote.datasource

import com.android.compose.data.remote.entities.DogsResponse
import com.android.compose.data.remote.ApiService
import com.android.compose.data.remote.common.safeApiCall
import retrofit2.Response
import javax.inject.Inject

class DogsRemoteDataSource @Inject constructor(private val dogService: ApiService) :
    DogsDataSource {

    override suspend fun fetchDogsList(dogType: String): Response<DogsResponse> =
        safeApiCall {
            dogService.getDogs(dogType)
        }
}