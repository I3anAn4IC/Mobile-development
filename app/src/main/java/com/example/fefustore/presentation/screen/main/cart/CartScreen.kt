package com.example.fefustore.presentation.screen.main.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fefustore.data.api.ProductApiService
import com.example.fefustore.domain.model.Product
import com.example.fefustore.presentation.screen.main.navigation.BottomNavBar
import com.example.fefustore.presentation.ui.component.ButtonCart
import com.example.fefustore.presentation.ui.component.CartTopBar
import com.example.fefustore.presentation.ui.theme.SfProTextSemibold
import kotlinx.coroutines.launch

@Composable
fun CartScreen(
    navController: NavController
) {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    var totalPrice = 0.00

    val apiServer = remember { ProductApiService() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                products = apiServer.getProducts()
                isLoading = false
            } catch (e: Exception) {
                errorMessage = e.message
                isLoading = false
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CartTopBar() },
        bottomBar = { BottomNavBar(navController) },
        containerColor = Color(0xFFF6F6F6)
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 100.dp, start = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Итого",
                            fontFamily = SfProTextSemibold,
                            fontSize = 20.sp,
                            letterSpacing = (0.38).sp,
                            color = Color(0xFF1A1A1A)
                        )

                        Text(
                            text = "${totalPrice} ₽",
                            fontFamily = SfProTextSemibold,
                            fontSize = 20.sp,
                            letterSpacing = (0.38).sp,
                            color = Color(0xFF1A1A1A)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ButtonCart(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Перейти к оформлению",
                            fontFamily = SfProTextSemibold,
                            fontSize = 17.sp,
                            letterSpacing = -(0.41).sp,
                            color = Color(0xFFFFFFFF)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}