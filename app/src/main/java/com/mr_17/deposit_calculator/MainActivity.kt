package com.mr_17.deposit_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mr_17.deposit_calculator.ui.theme.DepositCalculatorTheme
import com.mr_17.deposit_calculator.ui.theme.Red
import com.mr_17.deposit_calculator.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    DepositCalculatorTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopBar()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {
                CalculateCard(type = "Fixed Deposit", navController, Screen.FixedDepositScreen.route)
                CalculateCard(type = "Recurring Deposit", navController, Screen.RecurringDepositScreen.route)
            }
        }
    }
}

@Composable
fun FixedDepositScreen(navController: NavController) {
    DepositCalculatorTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopBar()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Deposit Calculator",
                style = TextStyle(
                    color = Yellow,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.passion_one))
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Red
        )
    )
}

@Composable
fun CalculateCard(type: String, navController: NavController, route: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp)
            .clickable { navController.navigate(route) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        border = BorderStroke(2.dp, Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Yellow, RectangleShape)
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .defaultMinSize(40.dp, 40.dp),
                painter = painterResource(R.drawable.ic_calculator),
                contentDescription = "Icon",
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                text = type,
                style = TextStyle(
                    color = Red,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.passion_one))
                )
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Navigation()
}