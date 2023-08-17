package com.example.ibanvalidator.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class IbanData(
    @SerializedName("account_number")
    @Expose
    val accountNumber: String,
    @SerializedName("BBAN")
    @Expose
    val bBAN: String,
    @SerializedName("bank_code")
    @Expose
    val bankCode: String,
    @SerializedName("branch")
    @Expose
    val branch: String,
    @SerializedName("checksum")
    @Expose
    val checksum: String,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("country_code")
    @Expose
    val countryCode: String,
    @SerializedName("country_iban_format_as_regex")
    @Expose
    val countryIbanFormatAsRegex: String,
    @SerializedName("country_iban_format_as_swift")
    @Expose
    val countryIbanFormatAsSwift: String,
    @SerializedName("national_checksum")
    @Expose
    val nationalChecksum: String,
    @SerializedName("sepa_country")
    @Expose
    val sepaCountry: Boolean
)