package data.repository

import core.Result
import core.Result.Success
import core.Result.Failure
import core.UnknownError
import domain.model.Product
import domain.repository.ProductRepository

class InMemoryProductRepository : ProductRepository {
    private val items = listOf(
        Product(id = "1", name = "Fishing Rod", price = 49.99),
        Product(id = "2", name = "Fishing Reel", price = 79.99),
        Product(id = "3", name = "Bait Pack", price = 9.99)
    )

    override suspend fun getProducts(): Result<List<Product>> {
        return try {
            Success(items)
        } catch (t: Throwable) {
            Failure(UnknownError(t.message))
        }
    }
}

