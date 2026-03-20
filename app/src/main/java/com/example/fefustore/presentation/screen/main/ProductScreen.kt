package com.example.fefustore.presentation.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.fefustore.R
import com.example.fefustore.data.api.ProductApiService
import com.example.fefustore.domain.model.Product
import com.example.fefustore.presentation.screen.main.navigation.MainScreenNavRoute
import com.example.fefustore.presentation.ui.component.BottomProductBar
import com.example.fefustore.presentation.ui.theme.SfProTextBold
import com.example.fefustore.presentation.ui.theme.SfProTextRegular
import com.example.fefustore.presentation.ui.theme.SfProTextSemibold
import kotlinx.coroutines.launch

@Composable
fun ProductScreen(
    productId: Int? = null,
    navController: NavController
) {
    var selectedSize by remember { mutableStateOf("XXS") }
    var product by remember { mutableStateOf<Product?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val selectSize = listOf(
        "XXS", "XS", "S", "M", "L", "XL"
    )

    val apiService = remember { ProductApiService() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(productId) {
        scope.launch {
            try {
                if (productId != null) {
                    product = apiService.getProductById(productId)
                } else {
                    val products = apiService.getProducts()
                    product = products.firstOrNull()
                }
                isLoading = false
            } catch (e: Exception) {
                errorMessage = e.message
                isLoading = false
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFFFFFFF),
        bottomBar = {
            product?.let {
                BottomProductBar(
                    product = it,
                    selectSize = selectSize,
                    selectedSize = selectedSize,
                    onSelectedSize = { selectedSize = it },
                    modifier = Modifier
                        .zIndex(2f)
                        .windowInsetsPadding(WindowInsets.navigationBars),
                    navController = navController,
                    onClick = {
                        navController.navigate(MainScreenNavRoute.Cart) {
                            popUpTo(MainScreenNavRoute.Catalog) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x661A1A1A))
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable(onClick = { navController.navigateUp() })
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.5f)
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = product?.imageUrl
                            ),
                            contentDescription = product?.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                        Surface(
                            modifier = Modifier
                                .height(24.dp)
                                .wrapContentWidth(),
                            shape = RoundedCornerShape(34.dp),
                            color = Color(0xFFA47764),) {
                            Text(
                                modifier = Modifier.padding(
                                    start = 6.dp,
                                    end = 6.dp,
                                    top = 5.dp,
                                    bottom = 6.dp
                                ),
                                text = product?.category ?: "",
                                fontFamily = SfProTextSemibold,
                                fontSize = 11.sp,
                                letterSpacing = -(0.23).sp,
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = product?.title ?: "",
                                    fontFamily = SfProTextBold,
                                    fontSize = 24.sp,
                                    letterSpacing = 0.sp,
                                    color = Color(0xFF1A1A1A)
                                )
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(id = R.drawable.info_icon),
                                    contentDescription = "info icon",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        item {
                            Text(
                                text = product?.description ?: "",
                                fontFamily = SfProTextRegular,
                                fontSize = 17.sp,
                                letterSpacing = -(0.41).sp,
                                color = Color(0xFF8C8C8C)
                            )
                        }
                    }
                }
            }
        }
    }
}
