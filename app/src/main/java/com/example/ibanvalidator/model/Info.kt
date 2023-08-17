package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Info {
    @SerializedName("rate")
    @Expose
    val rate: Double? = null

    @SerializedName("timestamp")
    @Expose
    val timestamp: Int? = null
}