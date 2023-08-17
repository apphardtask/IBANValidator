package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CurrencyConvertor {
    @SerializedName("date")
    @Expose
    val date: String? = null

    @SerializedName("error")
    @Expose
    val error: Error? = null

    @SerializedName("info")
    @Expose
    val info: Info? = null

    @SerializedName("query")
    @Expose
    val query: Query? = null

    @SerializedName("result")
    @Expose
    val result: Double? = null

    @SerializedName("success")
    @Expose
    val success: Boolean? = null
}