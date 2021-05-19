package com.android.compose.data.remote.common

import okhttp3.ResponseBody
import retrofit2.Response

suspend fun <T> safeApiCall(call: suspend () -> Response<T>): Response<T> {
    return try {
        val response = call()
        response
    } catch (e: Exception) {
        //not implemented code error because error handling not yet implemented
        val errorResponse = Response.error<T>(501, ResponseBody.create(null, "Error"))
        errorResponse
    }
}