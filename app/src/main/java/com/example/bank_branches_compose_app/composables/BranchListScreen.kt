package com.example.bank_branches_compose_app.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bank_branches_compose_app.repo.DummyBranches

@Composable
fun BranchListScreen(
    modefier:Modifier = Modifier,
    nav: NavController,
    favorite: MutableState<Int?>
) {
    Scaffold { innerPadding ->
        LazyColumn(modefier.padding(innerPadding)) {
            items(DummyBranches.list) { branch ->
                BranchCard(
                    branch = branch,
                    favoriteId = favorite.value,
                    onClick = { nav.navigate("details/${branch.id}") }
                )
            }
        }
    }
}
