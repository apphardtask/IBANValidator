package com.example.ibanvalidator.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.ibanvalidator.R
import com.example.ibanvalidator.classes.isIbanValid
import com.example.ibanvalidator.model.IbanValidate
import com.example.myapplication.networking.JetPackAPICall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IbanValidateViewModel: ViewModel() {

    var dataIbanValidate: IbanValidate by mutableStateOf(IbanValidate())
    var messageText:String by mutableStateOf("")
    var bankNameText:String by mutableStateOf("")
    var addressText:String by mutableStateOf("")


    fun ibanValidate(ibanNumber: String, context: Context, navHostController: NavHostController) {

        messageText = ""
        bankNameText = ""
        addressText = ""

        if(ibanNumber.isEmpty()){
            messageText = context.getString(R.string.EnterIban)
            return
        }

        if(!isIbanValid(ibanNumber.trim())){
            messageText = context.getString(R.string.IbanInvalid)
            return
        }

        val apiCall: Call<IbanValidate?>? = JetPackAPICall.apiInterface()?.ibanValidate(ibanNumber)

        apiCall?.enqueue(object : Callback<IbanValidate?> {
            override fun onResponse(call: Call<IbanValidate?>, response: Response<IbanValidate?>) {

                if (response?.isSuccessful == true) {

                    dataIbanValidate = response.body() ?: IbanValidate()

                    if(dataIbanValidate.valid == true){
//                        messageText = (dataIbanValidate.message ?: "") + "\n" +
//                                context.getString(R.string.IBANNumber) + ": " + dataIbanValidate.iban + "\n"
//                        context.getString(R.string.IBANNumber) + ": " + dataIbanValidate.ibanData?.accountNumber + "\n"
//                        context.getString(R.string.IBANNumber) + ": " + dataIbanValidate.bankData?.name + "\n"
//                        context.getString(R.string.IBANNumber) + ": " + dataIbanValidate.bankData?.city + ", " +
//                                dataIbanValidate.bankData?.zip + ", " + dataIbanValidate.ibanData?.country
                        messageText =
                        context.getString(R.string.AccountNumber) + ": " + dataIbanValidate.ibanData?.accountNumber
                        bankNameText = context.getString(R.string.BankName) + ": " + dataIbanValidate.bankData?.name
                        addressText = context.getString(R.string.Address) + ": " + dataIbanValidate.bankData?.city + ", " +
                                dataIbanValidate.bankData?.zip + ", " + dataIbanValidate.ibanData?.country
                    } else{
                        messageText = dataIbanValidate.errors?.ibanNumber?.firstOrNull()?.toString() ?: ""
                    }

                }

            }

            override fun onFailure(call: Call<IbanValidate?>, t: Throwable) {
            }

        })

    }

}