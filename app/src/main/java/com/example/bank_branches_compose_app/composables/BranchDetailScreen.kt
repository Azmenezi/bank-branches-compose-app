package com.example.bank_branches_compose_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bank_branches_compose_app.R
import com.example.bank_branches_compose_app.repo.DummyBranches

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchDetailScreen(
    id: Int,
    nav: NavController,
    favorite: MutableState<Int?>
) {
    val branch = DummyBranches.byId(id)
    val uri = LocalUriHandler.current
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(branch.name) },
                navigationIcon = {
                    IconButton(onClick = { nav.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) { pad ->
        Column(Modifier.padding(pad).padding(16.dp)) {
            Image(
                painterResource(branch.imageRes ?: R.drawable.branch_placeholder),
                contentDescription = branch.name,
                modifier = Modifier.fillMaxWidth().height(180.dp)
            )
            Spacer(Modifier.height(12.dp))
            Text(branch.address)
            Text(branch.phone)
            Text(branch.hours)
            Spacer(Modifier.height(12.dp))
            Button(onClick = { uri.openUri(branch.location) }) {
                Text("Open in Maps")
            }
            Spacer(Modifier.height(8.dp))
            val isFav = favorite.value == branch.id

            Button(
                onClick = { favorite.value = branch.id },
                enabled = !isFav,
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (isFav) MaterialTheme.colorScheme.primaryContainer
                    else MaterialTheme.colorScheme.tertiary      // red accent
                )
            ) {
                Icon(Icons.Default.Star, null)
                Spacer(Modifier.width(4.dp))
                Text(if (isFav) "Favorite" else "Set Favorite")
            }
        }
    }
}
