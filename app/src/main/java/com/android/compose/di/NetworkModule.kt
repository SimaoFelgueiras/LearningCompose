package com.android.compose.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.android.compose.data.remote.ApiConstants.BASE_URL
import com.android.compose.data.remote.ApiService
import com.android.compose.data.remote.datasource.DogsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    fun provideDogService(retrofit: Retrofit): ApiService=
        retrofit.create(ApiService::class.java)
}