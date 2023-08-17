package com.example.myapplication.networking


import com.example.ibanvalidator.model.CurrencyConvertor
import com.example.ibanvalidator.model.IbanValidate
import retrofit2.Call
import retrofit2.http.*

interface JetPackAPIInterface {

    @GET("bank_data/iban_validate")
    fun ibanValidate(
        @Query("iban_number") iban_number: String?,
    ): Call<IbanValidate?>?

    @GET("fixer/convert")
    fun convert(
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("amount") amount: String?,
    ): Call<CurrencyConvertor?>?

}