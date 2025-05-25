package com.example.bank_branches_compose_app.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bank_branches_compose_app.composables.BranchDetailScreen
import com.example.bank_branches_compose_app.composables.BranchListScreen

@Composable
fun AppNav(nav: NavHostController, favorite: MutableState<Int?>) {
    NavHost(nav, "list") {
        composable("list") { BranchListScreen(nav = nav, favorite = favorite) }
        composable("details/{id}") { back ->
            val id = back.arguments?.getString("id")?.toInt() ?: return@composable
            BranchDetailScreen(id, nav, favorite)
        }
    }
}
