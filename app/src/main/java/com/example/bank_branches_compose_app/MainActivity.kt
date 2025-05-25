package com.example.bank_branches_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import com.example.bank_branches_compose_app.nav.AppNav
import com.example.bank_branches_compose_app.ui.theme.BankBranchesComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankBranchesComposeAppTheme {
                val nav = rememberNavController()
                val favorite = rememberSaveable { mutableStateOf<Int?>(null) }
                AppNav(nav, favorite)
            }
        }
    }
}
