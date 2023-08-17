package com.example.ibanvalidator.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.ibanvalidator.R
import com.example.ibanvalidator.classes.isIbanValid
import com.example.ibanvalidator.model.CurrencyConvertor
import com.example.ibanvalidator.model.IbanValidate
import com.example.myapplication.networking.JetPackAPICall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyViewModel: ViewModel() {

    var dataCurrencyConvertor: CurrencyConvertor by mutableStateOf(CurrencyConvertor())
    var messageText:String by mutableStateOf("")
    var bankNameText:String by mutableStateOf("")
    var addressText:String by mutableStateOf("")


    fun convert(from: String, to: String, amount: String, context: Context, navHostController: NavHostController) {

        messageText = ""
        bankNameText = ""
        addressText = ""

        if(from.isEmpty()){
            messageText = context.getString(R.string.FromCurrency)
            return
        }

        if(to.isEmpty()){
            messageText = context.getString(R.string.ToCurrency)
            return
        }

        if(amount.isEmpty()){
            messageText = context.getString(R.string.EnterAmount)
            return
        }

        val apiCall: Call<CurrencyConvertor?>? = JetPackAPICall.apiInterface()?.convert(from.trim(), to.trim(), amount.trim())

        apiCall?.enqueue(object : Callback<CurrencyConvertor?> {
            override fun onResponse(
                call: Call<CurrencyConvertor?>,
                response: Response<CurrencyConvertor?>
            ) {

                if (response?.isSuccessful == true) {

                    dataCurrencyConvertor = response.body() ?: CurrencyConvertor()

                    if(dataCurrencyConvertor.success == true){
                        messageText =
                            context.getString(R.string.Conversion) + ": " + dataCurrencyConvertor.result + " " + dataCurrencyConvertor.query?.to
                        bankNameText = context.getString(R.string.Rate) + ": " + dataCurrencyConvertor.info?.rate
                    } else{

                        messageText = dataCurrencyConvertor.error?.info?.replace("\\", "") ?: ""

                    }

                }

            }

            override fun onFailure(call: Call<CurrencyConvertor?>, t: Throwable) {
            }

        })

    }

}