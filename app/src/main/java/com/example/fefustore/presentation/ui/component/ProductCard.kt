package com.example.fefustore.presentation.ui.component

import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fefustore.domain.model.Product
import com.example.fefustore.presentation.ui.theme.SfProTextRegular
import com.example.fefustore.presentation.ui.theme.SfProTextSemibold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    product: Product,
    quantity: Int = 0,
    isInCart: Boolean = false,
    onAddToCart: () -> Unit = {},
    onIncreaseQuantity: () -> Unit = {},
    onDecreaseQuantity: () -> Unit = {},
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clickable{ onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = product.title,
                modifier = Modifier.size(136.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier .fillMaxSize()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = product.title,
                        fontFamily = SfProTextSemibold,
                        fontSize = 18.sp,
                        letterSpacing = 0.sp,
                        color = Color(0xFF1A1A1A)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = product.description,
                        fontFamily = SfProTextRegular,
                        fontSize = 15.sp,
                        letterSpacing = (-0.24).sp,
                        color = Color(0xFF8C8C8C),
                        maxLines = 4
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                AddToCart(
                    onClick = {}
                ) {
                    Text(
                        text = "${product.price.toInt()} ₽",
                        fontFamily = SfProTextSemibold,
                        fontSize = 15.sp,
                        letterSpacing = (-0.5).sp,
                        color = Color(0xFF623A29)
                    )
                }
            }
        }
    }
}
