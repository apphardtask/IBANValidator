package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class BankData(
    @SerializedName("bank_code")
    @Expose
    val bankCode: String,
    @SerializedName("bic")
    @Expose
    val bic: String,
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("zip")
    @Expose
    val zip: String
)