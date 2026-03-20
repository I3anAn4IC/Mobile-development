package com.example.fefustore.presentation.screen.main.navigation

import kotlinx.serialization.Serializable

sealed interface MainScreenNavRoute {
    @Serializable
    data object Catalog: MainScreenNavRoute

    @Serializable
    data object Cart: MainScreenNavRoute

    @Serializable
    data class Product(val productId: Int) : MainScreenNavRoute
}