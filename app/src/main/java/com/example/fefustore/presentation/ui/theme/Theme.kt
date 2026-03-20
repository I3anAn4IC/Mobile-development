package com.example.fefustore.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.fefustore.presentation.ui.Black
import com.example.fefustore.presentation.ui.Gray
import com.example.fefustore.presentation.ui.LightGray
import com.example.fefustore.presentation.ui.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = Gray,
    tertiary = LightGray,
)

private val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = Gray,
    tertiary = LightGray
)

val Typography = Typography(
    labelSmall = TextStyle(
        fontFamily = SfProTextFontFamily,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = TextStyle(
        fontFamily = SfProTextFontFamily,
        fontWeight = FontWeight.Normal
    )
)

@Composable
fun FEFUStoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}