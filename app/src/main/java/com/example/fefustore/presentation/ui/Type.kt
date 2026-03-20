package com.example.fefustore.presentation.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.fefustore.presentation.ui.theme.SfProTextBold
import com.example.fefustore.presentation.ui.theme.SfProTextMedium
import com.example.fefustore.presentation.ui.theme.SfProTextRegular
import com.example.fefustore.presentation.ui.theme.SfProTextSemibold

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = SfProTextMedium,
        fontSize = 14.sp,
        letterSpacing = (-0.3).sp
    ),

    displaySmall = TextStyle(
        fontFamily = SfProTextMedium,
        fontSize = 14.sp,
        letterSpacing = (-0.3).sp
    ),

    displayMedium = TextStyle(
        fontFamily = SfProTextMedium,
        fontSize = 12.sp,
        letterSpacing = (-0.3).sp
    ),

    titleMedium = TextStyle(
        fontFamily = SfProTextSemibold,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),

    titleLarge = TextStyle(
        fontFamily = SfProTextBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),

    titleSmall = TextStyle(
        fontFamily = SfProTextRegular,
        fontSize = 15.sp,
        letterSpacing = (-0.24).sp
    ),

    bodyLarge = TextStyle(
        fontFamily = SfProTextRegular,
        fontSize = 17.sp,
        letterSpacing = (-0.41).sp
    ),

    bodyMedium = TextStyle(
        fontFamily = SfProTextSemibold,
        fontSize = 15.sp,
        letterSpacing = (-0.5).sp
    ),

    bodySmall = TextStyle(
        fontFamily = SfProTextSemibold,
        fontSize = 11.sp,
        letterSpacing = (-0.23).sp
    ),

    labelSmall = TextStyle(
        fontFamily = SfProTextSemibold,
        fontSize = 17.sp,
        letterSpacing = (-0.41).sp
    )
)