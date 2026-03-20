package com.example.fefustore.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fefustore.domain.model.Product

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateOf<Map<Int, Int>>(emptyMap())
    val cartItems: State<Map<Int, Int>> = _cartItems

    fun addToCart(product: Product) {
        val currentMap = _cartItems.value.toMutableMap()
        val currentQuantity = currentMap[product.id] ?: 0
        currentMap[product.id] = currentQuantity + 1
        _cartItems.value = currentMap
    }

    fun increaseQuantity(product: Product) {
        val currentMap = _cartItems.value.toMutableMap()
        val currentQuantity = currentMap[product.id] ?: 0
        currentMap[product.id] = currentQuantity + 1
        _cartItems.value = currentMap
    }

    fun decreaseQuantity(product: Product) {
        val currentMap = _cartItems.value.toMutableMap()
        val currentQuantity = currentMap[product.id] ?: 0

        if (currentQuantity <= 1) {
            currentMap.remove(product.id)
        } else {
            currentMap[product.id] = currentQuantity - 1
        }
        _cartItems.value = currentMap
    }

    fun getQuantity(productId: Int): Int {
        return _cartItems.value[productId] ?: 0
    }

    fun clearCart() {
        _cartItems.value = emptyMap()
    }
}