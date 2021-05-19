package com.android.compose.domain.usecase

import com.android.compose.data.remote.common.Resource
import com.android.compose.data.remote.entities.DogsResponse
import kotlinx.coroutines.flow.Flow

interface DogsUseCaseContract {
    suspend fun fetchDogs(type:String): Flow<Resource<DogsResponse?>>
}