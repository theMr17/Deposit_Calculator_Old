package com.mr_17.deposit_calculator

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object FixedDepositScreen: Screen("fixed_deposit_screen")
    object RecurringDepositScreen: Screen("recurring_deposit_screen")
}
