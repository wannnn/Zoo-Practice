package com.example.zoopractice.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    @Json(name = "E_Category") val category: String = "",
    @Json(name = "E_Geo") val geo: String = "",
    @Json(name = "E_Info") val info: String = "",
    @Json(name = "E_Memo") var _memo: String = "",
    @Json(name = "E_Name") val name: String = "",
    @Json(name = "E_Pic_URL") val picUrl: String = "",
    @Json(name = "E_URL") val url: String = "",
    @Json(name = "E_no") val no: String = "",
    @Json(name = "_id") val id: Int = 0
) : Parcelable {
    var memo = ""
        get() = when(_memo) {
                "" -> "無休館資訊"
                else -> _memo
        }
}

