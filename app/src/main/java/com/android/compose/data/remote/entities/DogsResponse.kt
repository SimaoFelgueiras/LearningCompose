package com.android.compose.data.remote.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Might replace with moshi
@Parcelize
data class DogsResponse(val message: List<Dog>?) : Parcelable