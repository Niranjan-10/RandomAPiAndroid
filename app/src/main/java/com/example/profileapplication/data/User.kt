package com.example.profileapplication.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("results")
    var result: List<Result>
) : Parcelable {
    @Parcelize
    data class Result(
        @SerializedName("gender")
        var gender: String,
        @SerializedName("email")
        var email: String,
        @SerializedName("picture")
        var pictures: Pictures
    ) : Parcelable  {
        @Parcelize
        data class Pictures(
            @SerializedName("medium")
            var medium: String
        ) : Parcelable

    }


}

//data class UserList(
//    @SerializedName("page") val page: Int,
//    @SerializedName("per_page") val per_page: Int,
//    @SerializedName("total") val total: Int,
//    @SerializedName("total_pages") val total_pages: Int,
//    @SerializedName("data") val data: List<User>
//){
//    data class User(
//        @SerializedName("id") val id : Int,
//        @SerializedName("email") val email : String,
//        @SerializedName("first_name") val first_name : String,
//        @SerializedName("last_name") val last_name : String,
//        @SerializedName("avatar") val avatar : String
//    )
//}




