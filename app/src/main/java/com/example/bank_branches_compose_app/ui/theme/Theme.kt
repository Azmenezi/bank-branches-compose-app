package com.example.bank_branches_compose_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val AppColors = lightColorScheme(
    primary            = BlueMain,
    onPrimary          = Color.White,

    primaryContainer   = BlueGray,
    onPrimaryContainer = Color.White,

    secondary          = PurpleGray,
    onSecondary        = Color.White,

    tertiary           = AccentRed,
    onTertiary         = Color.White,

    background         = GrayLight,
    onBackground       = GrayDark,

    surface            = Color.White,
    onSurface          = GrayDark,

    error              = AccentRed,
    onError            = Color.White
)

@Composable
fun BankBranchesComposeAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColors,
        typography  = MaterialTheme.typography,
        content     = content
    )
}
