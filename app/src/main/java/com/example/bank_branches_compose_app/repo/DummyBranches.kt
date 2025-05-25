package com.example.bank_branches_compose_app.repo

import com.example.bank_branches_compose_app.R
import com.example.bank_branches_compose_app.model.*

object DummyBranches {
    val list = listOf(
        Branch(
            1, "Head Office", BranchType.MAIN,
            "Ahmed Al-Jaber St.", "+965 2222 0000", "Sun-Thu 8-3",
            "https://maps.google.com/?q=29.3759,47.9774",
            R.drawable.branch_ho
        ),
        Branch(
            2, "Salmiya ATM", BranchType.ATM,
            "Salmiya Blvd", "+965 2222 0001", "24/7",
            "https://maps.google.com/?q=29.3334,48.0765"
        )
    )

    fun byId(id: Int) = list.first { it.id == id }
}
