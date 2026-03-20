package com.example.fefustore.presentation.screen.main.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.fefustore.data.api.ProductApiService
import com.example.fefustore.domain.model.Product
import com.example.fefustore.presentation.screen.main.navigation.BottomNavBar
import com.example.fefustore.presentation.ui.component.FilterTopBar
import com.example.fefustore.presentation.ui.component.ProductCard
import kotlinx.coroutines.launch

@Composable
fun CatalogScreen(
    onProductClick: (Int) -> Unit = {},
    navController: NavController
) {
    var selectedFilter by remember { mutableStateOf("Все") }
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val filters = listOf(
        "Все",
        "Новинки",
        "Джинсы",
        "Футболки",
        "Рубашки",
        "Куртки",
    )

    val apiService = remember { ProductApiService() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                products = apiService.getProducts()
                isLoading = false
            } catch (e: Exception) {
                errorMessage = e.message
                isLoading = false
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FilterTopBar(
                filters = filters,
                selectedFilter = selectedFilter,
                onFilterSelected = { selectedFilter = it },
                modifier = Modifier.zIndex(2f).padding(top = 16.dp)
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFFFFFFF))
            ) {
                items(products) { product ->
                    ProductCard(
                        product = product,
                        onClick = {
                            onProductClick(product.id)
                        },
                        onAddToCart = {
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }

            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if (errorMessage != null) {
                Text(
                    text = "Ошибка: $errorMessage",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red
                )
            }
        }
    }
}