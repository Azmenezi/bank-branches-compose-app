package com.example.bank_branches_compose_app.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bank_branches_compose_app.R
import com.example.bank_branches_compose_app.model.Branch

@Composable
fun BranchCard(
    branch: Branch,
    favoriteId: Int?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val fav = branch.id == favoriteId
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (fav)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surface
        )
    ) {
        Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {

            Image(
                painterResource(branch.imageRes ?: R.drawable.branch_placeholder),
                contentDescription = branch.name,
                modifier = Modifier.size(70.dp)
            )

            Column(Modifier.weight(1f)) {
                Text(branch.name, style = MaterialTheme.typography.titleMedium)
                Text(branch.address, style = MaterialTheme.typography.bodySmall)
            }

            if (fav) Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}