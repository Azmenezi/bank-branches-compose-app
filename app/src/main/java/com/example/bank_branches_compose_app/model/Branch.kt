package com.example.bank_branches_compose_app.model

import androidx.annotation.DrawableRes

enum class BranchType { MAIN, ATM, SERVICE }

data class Branch(
    val id: Int,
    val name: String,
    val type: BranchType,
    val address: String,
    val phone: String,
    val hours: String,
    val location: String,
    @DrawableRes val imageRes: Int? = null
)
