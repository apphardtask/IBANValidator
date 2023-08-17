package com.example.ibanvalidator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ibanvalidator.Screens.CurrencyConvertorScreen
import com.example.ibanvalidator.Screens.HomeScreen
import com.example.ibanvalidator.Screens.IBANValidatorScreen
import com.example.ibanvalidator.ui.theme.IBANValidatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IBANValidatorTheme {
                ComposeNavigation()
            }
        }
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController)
        }
        composable("IBANValidatorScreen"){
            IBANValidatorScreen(navController)
        }
        composable("CurrencyConvertorScreen"){
            CurrencyConvertorScreen(navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String, navHostController: NavHostController){
    Column {
        androidx.compose.material3.TopAppBar(
            title = {
                Text(title)
            },
            colors =  TopAppBarDefaults.smallTopAppBarColors(),
            navigationIcon = {
                IconButton(onClick = {
                    navHostController.navigateUp()
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            })
    }
}