package domain.repository

import domain.model.Product
import core.Result

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>>
}
