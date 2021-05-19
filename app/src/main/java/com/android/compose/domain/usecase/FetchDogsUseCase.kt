package com.android.compose.domain.usecase

import com.android.compose.data.remote.common.Resource
import com.android.compose.data.remote.entities.DogsResponse
import com.android.compose.domain.repository.DogsRepositoryContract
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDogsUseCase @Inject constructor(private val dogsRepository: DogsRepositoryContract) :
    DogsUseCaseContract {
    override suspend fun fetchDogs(type: String): Flow<Resource<DogsResponse?>> =
        dogsRepository.fetchDogs(type)
}