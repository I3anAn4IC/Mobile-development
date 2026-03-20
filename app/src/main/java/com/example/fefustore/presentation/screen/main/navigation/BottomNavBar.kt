package com.example.fefustore.presentation.screen.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fefustore.R
import com.example.fefustore.domain.util.BottomNavItem
import com.example.fefustore.presentation.ui.Black
import com.example.fefustore.presentation.ui.LightGray
import com.example.fefustore.presentation.ui.theme.SfProTextMedium


@Composable
fun BottomNavBar(
    navController: NavController
) {
    val bottomNavItems = listOf(
        BottomNavItem(
            icon = painterResource(id = R.drawable.menu_icon),
            titleResId = R.string.titleNavMenu,
            route = MainScreenNavRoute.Catalog
        ),
        BottomNavItem(
            icon = painterResource(id = R.drawable.cart_icon),
            titleResId = R.string.titleNavCart,
            route = MainScreenNavRoute.Cart
        ),
    )

    val currentRoute = navController.currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)
        .value?.destination?.route

    val selectedItemIndex = remember(currentRoute) {
        bottomNavItems.indexOfFirst { item ->
            currentRoute?.contains(item.route::class.simpleName ?: "", ignoreCase = true) == true
        }.takeIf { it >= 0 } ?: 0
    }

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
        NavigationBar(
            containerColor = Color(0xFFFFFFFF),
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.navigationBars),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(0) { inclusive = true }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = item.icon,
                                contentDescription = "BottomNavItem icon"
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = item.titleResId),
                                fontFamily = SfProTextMedium,
                                fontSize = 12.sp,
                                letterSpacing = (-0.3).sp
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            selectedIconColor = Black,
                            unselectedIconColor = LightGray,
                            selectedTextColor = Black,
                            unselectedTextColor = LightGray
                        )
                    )
                }
            }
        }
    }
}
