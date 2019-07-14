package com.example.zoopractice.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServerResponse(
    val result: Result = Result()
) : Parcelable