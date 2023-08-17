package com.example.ibanvalidator.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.ibanvalidator.TopAppBar
import com.example.ibanvalidator.R
import com.example.ibanvalidator.viewmodel.IbanValidateViewModel

@Composable
fun IBANValidatorScreen(navHostController: NavHostController)  {
    val ibanValidateViewModel: IbanValidateViewModel = viewModel()
    Column {
        TopAppBar(LocalContext.current.getString(R.string.IBANValidator), navHostController)
        CreateIBANValidatorUI(ibanValidateViewModel, navHostController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateIBANValidatorUI(ibanValidateViewModel: IbanValidateViewModel, navHostController: NavHostController){

    val ibanTextState = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top) {

        OutlinedTextField(modifier =
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
            value = ibanTextState.value,
            onValueChange = { text -> ibanTextState.value = text },
            placeholder = { Text(text = LocalContext.current.getString(R.string.IBANNumber)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                ibanValidateViewModel.ibanValidate(ibanTextState.value.text, context, navHostController)
            })
        {
            Text(text = LocalContext.current.getString(R.string.Submit),
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
        }
        Text(text = ibanValidateViewModel.messageText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
        Text(text = ibanValidateViewModel.bankNameText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
        Text(text = ibanValidateViewModel.addressText,
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally).fillMaxWidth())
    }
}