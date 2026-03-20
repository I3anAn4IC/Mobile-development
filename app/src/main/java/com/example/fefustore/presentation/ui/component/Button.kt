package com.example.fefustore.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddToCart(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
        onClick = onClick,
        shape = RoundedCornerShape(size = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF6EFEB)
        )
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 4.dp)
        ) {
            content()
        }
    }
}

@Composable
fun ButtonCart(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
        onClick = onClick,
        shape = RoundedCornerShape(size = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFA47764),
            contentColor = Color(0xFFFFFFFF)
        )
    ) {
        Box(
            modifier = Modifier.padding(start = 24.dp, top = 14.dp, end = 24.dp, bottom = 15.dp)
        ) {
            content()
        }
    }
}
