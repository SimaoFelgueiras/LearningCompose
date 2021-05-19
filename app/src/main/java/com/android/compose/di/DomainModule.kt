package com.android.compose.di

import com.android.compose.data.remote.datasource.DogsDataSource
import com.android.compose.domain.repository.DogsRepository
import com.android.compose.domain.repository.DogsRepositoryContract
import com.android.compose.domain.usecase.FetchDogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideDogsRepository(dogsDataSource: DogsDataSource) =
        DogsRepository(dogsDataSource)

    @Singleton
    @Provides
    fun provideDogsUseCase(dogsRepository: DogsRepositoryContract) =
        FetchDogsUseCase(dogsRepository)
}