package com.android.compose.data.remote.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

suspend fun <T> performRequest(networkCall: suspend () -> Response<T>): Flow<Resource<T?>> =
    flow {
        emit(Resource.loading(null) as Resource<T>)
        val responseStatus = networkCall.invoke()
        if (responseStatus.isSuccessful) {
            emit(Resource.success(responseStatus.body()))
        } else if (!responseStatus.isSuccessful) {
            emit(Resource.error(responseStatus.message(), null))
        }
    }