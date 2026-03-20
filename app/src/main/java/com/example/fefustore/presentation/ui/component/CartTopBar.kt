package com.example.fefustore.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fefustore.R
import com.example.fefustore.presentation.ui.theme.SfProTextBold

@Composable
fun CartTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 12.dp, vertical = 9.dp)
    ) {
        Text(
            text = "Корзина",
            modifier = Modifier.align(Alignment.Center),
            fontFamily = SfProTextBold,
            fontSize = 24.sp,
            letterSpacing = 0.sp,
            color = Color(0xFF1A1A1A),
            textAlign = TextAlign.Center
        )

        ButtonDeleteCart(
            onClick = {},
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.delete_icon),
                contentDescription = "delete icon",
                tint = Color.Unspecified
            )
        }
    }
}