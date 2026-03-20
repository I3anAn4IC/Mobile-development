package com.example.fefustore.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fefustore.domain.model.Product
import com.example.fefustore.presentation.ui.theme.SfProTextSemibold

@Composable
fun BottomProductBar(
    product: Product,
    selectSize: List<String>,
    selectedSize: String,
    onSelectedSize: (String) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .dropShadow(
                shape = RoundedCornerShape(0.dp),
                shadow = Shadow(
                    radius = 15.dp,
                    spread = (-5).dp,
                    color = Color(0x4082888E),
                    offset = DpOffset(x = 0.dp, y = (-2).dp)
                )
            )
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFFFFF)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 8.dp)
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(selectSize) { selectSize ->
                        FilterButton(
                            text = selectSize,
                            isSelected = selectedSize == selectSize,
                            onClick = { onSelectedSize(selectSize) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color(0xFFF6EFEB)
                )

                Spacer(modifier = Modifier.height(12.dp))

                ButtonCart(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "В корзину · ${product.price.toInt()} ₽",
                        fontFamily = SfProTextSemibold,
                        fontSize = 15.sp,
                        letterSpacing = (-0.5).sp,
                        color = Color(0xFFFFFFFF)
                    )
                }
            }
        }
    }
}