package com.example.ibanvalidator.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ibanvalidator.R
import com.example.ibanvalidator.TopAppBar

@Composable
fun HomeScreen(navHostController: NavHostController)  {

    Column {
        TopAppBar(LocalContext.current.getString(R.string.Home), navHostController)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    navHostController.navigate("IBANValidatorScreen")
                }){
                Text(text = LocalContext.current.getString(R.string.IBANValidator),
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    navHostController.navigate("CurrencyConvertorScreen")
                }){
                Text(text = LocalContext.current.getString(R.string.CurrencyConvertor),
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            }
        }
    }
}