package com.example.ibanvalidator.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ibanvalidator.R
import com.example.ibanvalidator.TopAppBar
import com.example.ibanvalidator.viewmodel.CurrencyViewModel
import com.example.ibanvalidator.viewmodel.IbanValidateViewModel

@Composable
fun CurrencyConvertorScreen(navHostController: NavHostController)  {
    val currencyViewModel: CurrencyViewModel = viewModel()
    Column {
        TopAppBar(LocalContext.current.getString(R.string.IBANValidator), navHostController)
        CurrencyConvertorrUI(currencyViewModel, navHostController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConvertorrUI(currencyViewModel: CurrencyViewModel, navHostController: NavHostController){

    val fromTextState = remember { mutableStateOf(TextFieldValue()) }
    val toTextState = remember { mutableStateOf(TextFieldValue()) }
    val amountTextState = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top) {

        OutlinedTextField(modifier =
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = fromTextState.value,
            onValueChange = { text -> fromTextState.value = text },
            placeholder = { Text(text = LocalContext.current.getString(R.string.From)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(modifier =
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(top = 16.dp),
            value = toTextState.value,
            onValueChange = { text -> toTextState.value = text },
            placeholder = { Text(text = LocalContext.current.getString(R.string.To)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(modifier =
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(top = 16.dp),
            value = amountTextState.value,
            onValueChange = { text -> amountTextState.value = text },
            placeholder = { Text(text = LocalContext.current.getString(R.string.Amount)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                currencyViewModel.convert(fromTextState.value.text, toTextState.value.text, amountTextState.value.text, context, navHostController)
            })
        {
            Text(text = LocalContext.current.getString(R.string.Submit),
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
        }
        Text(text = currencyViewModel.messageText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
        Text(text = currencyViewModel.bankNameText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
        Text(text = currencyViewModel.addressText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
    }
}