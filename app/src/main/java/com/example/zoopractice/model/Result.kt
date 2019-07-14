package com.example.zoopractice.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val count: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0,
    val results: List<Results> = listOf(),
    val sort: String? = ""
) : Parcelable