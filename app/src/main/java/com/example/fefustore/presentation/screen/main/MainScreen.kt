package com.example.fefustore.presentation.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fefustore.presentation.navigation.Screen
import com.example.fefustore.presentation.screen.main.cart.CartScreen
import com.example.fefustore.presentation.screen.main.catalog.CatalogScreen
import com.example.fefustore.presentation.screen.main.navigation.MainScreenNavRoute

@Composable
fun MainScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreenNavRoute.Catalog
    ) {
        composable<MainScreenNavRoute.Catalog> {
            CatalogScreen(
                onProductClick = { productId ->
                    navController.navigate(MainScreenNavRoute.Product(productId))
                },
                navController
            )
        }

        composable<MainScreenNavRoute.Cart> {
            CartScreen(navController)
        }

        composable<MainScreenNavRoute.Product> { backStackEntry ->
            val route = backStackEntry.toRoute<MainScreenNavRoute.Product>()
            ProductScreen(
                productId = route.productId,
                navController = navController
                )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen()
}