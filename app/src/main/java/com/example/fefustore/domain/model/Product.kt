package com.example.fefustore.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    @SerialName("image") val imageUrl: String,
    @SerialName("rating") val rating: Rating? = null
)

@Serializable
data class Rating(
    val rate: Double,
    val count: Int
)