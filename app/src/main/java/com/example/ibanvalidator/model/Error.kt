package com.example.ibanvalidator.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Error {
    @SerializedName("code")
    @Expose
    val code: Int? = null
    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("info")
    @Expose
    val info: String? = null
}