package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Errors(
    @SerializedName("iban_number")
    @Expose
    val ibanNumber: ArrayList<String>
)