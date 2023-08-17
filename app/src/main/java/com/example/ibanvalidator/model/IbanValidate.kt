package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class IbanValidate {
    @SerializedName("bank_data")
    @Expose
    val bankData: BankData? = null

    @SerializedName("country_iban_example")
    @Expose
    val countryIbanExample: String? = null

    @SerializedName("iban")
    @Expose
    val iban: String? = null

    @SerializedName("iban_data")
    @Expose
    val ibanData: IbanData? = null

    @SerializedName("errors")
    @Expose
    val errors: Errors? = null

    @SerializedName("message")
    @Expose
    val message: String? = null

    @SerializedName("valid")
    @Expose
    val valid: Boolean? = null
}