package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Query {
    @SerializedName("amount")
    @Expose
    val amount: Int? = null

    @SerializedName("from")
    @Expose
    val from: String? = null

    @SerializedName("to")
    @Expose
    val to: String? = null
}