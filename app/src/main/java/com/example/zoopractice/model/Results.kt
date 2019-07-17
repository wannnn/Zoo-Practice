package com.example.zoopractice.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Results(
    @Json(name = "E_Category") val category: String = "",
    @Json(name = "E_Geo") val geo: String = "",
    @Json(name = "E_Info") val info: String = "",
    @Json(name = "E_Memo") var memo: String = "",
    @Json(name = "E_Name") val name: String = "",
    @Json(name = "E_Pic_URL") val picUrl: String = "",
    @Json(name = "E_URL") val url: String = "",
    @Json(name = "E_no") val no: String = "",
    @PrimaryKey @Json(name = "_id") val id: Int = 0
) : Parcelable {
    var e_memo = ""
        get() = when(memo) {
                "" -> "無休館資訊"
                else -> memo
        }
}


