package com.example.fefustore.data.api

import com.example.fefustore.domain.model.Product
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ProductApiService {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getProducts(): List<Product> {
        return client.get("https://fakestoreapi.com/products").body()
    }

    suspend fun getProductById(id: Int): Product {
        return client.get("https://fakestoreapi.com/products/$id").body()
    }

    suspend fun getProductsByCategory(category: String): List<Product> {
        return client.get("https://fakestoreapi.com/products/category/$category").body()
    }

    suspend fun getCategories(): List<String> {
        return client.get("https://fakestoreapi.com/products/categories").body()
    }
}