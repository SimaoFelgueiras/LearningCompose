package com.android.compose.data.remote.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogsResponse(val message: List<String>?) : Parcelable