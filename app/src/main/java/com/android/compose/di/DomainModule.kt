package com.android.compose.di

import com.android.compose.data.remote.ApiService
import com.android.compose.data.remote.datasource.DogsDataSource
import com.android.compose.data.remote.datasource.DogsRemoteDataSource
import com.android.compose.domain.repository.DogsRepository
import com.android.compose.domain.repository.DogsRepositoryContract
import com.android.compose.domain.usecase.FetchDogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideDogsDataSource(dogService: ApiService) =
        DogsRemoteDataSource(dogService)

    @ViewModelScoped
    @Provides
    fun provideDogsRepository(dogsDataSource: DogsRemoteDataSource) =
        DogsRepository(dogsDataSource)

    @ViewModelScoped
    @Provides
    fun provideDogsUseCase(dogsRepository: DogsRepository) =
        FetchDogsUseCase(dogsRepository)
}