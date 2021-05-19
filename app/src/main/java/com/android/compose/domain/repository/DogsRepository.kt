package com.android.compose.domain.repository

import com.android.compose.data.remote.common.Resource
import com.android.compose.data.remote.common.performRequest
import com.android.compose.data.remote.datasource.DogsDataSource
import com.android.compose.data.remote.entities.DogsResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogsRepository @Inject constructor(private val dogsRemoteDataSource: DogsDataSource) :
    DogsRepositoryContract {
    override suspend fun fetchDogs(type: String): Flow<Resource<DogsResponse?>> =
        performRequest {
            dogsRemoteDataSource.fetchDogsList(type)
        }
}