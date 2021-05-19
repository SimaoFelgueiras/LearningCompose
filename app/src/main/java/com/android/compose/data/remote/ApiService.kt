package com.android.compose.data.remote

import com.android.compose.data.remote.entities.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("breed/{dogType}/images")
    suspend fun getDogs(@Path("dogType") dogType: String): Response<DogsResponse>
}