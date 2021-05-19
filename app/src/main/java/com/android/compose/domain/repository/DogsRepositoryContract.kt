package com.android.compose.domain.repository

import com.android.compose.data.remote.common.Resource
import com.android.compose.data.remote.entities.DogsResponse
import kotlinx.coroutines.flow.Flow

interface DogsRepositoryContract {
    suspend fun fetchDogs(type: String): Flow<Resource<DogsResponse?>>
}