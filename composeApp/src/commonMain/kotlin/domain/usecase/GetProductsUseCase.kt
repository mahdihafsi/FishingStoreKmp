package domain.usecase

import domain.repository.ProductRepository
import core.Result
import domain.model.Product

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): Result<List<Product>> = repository.getProducts()
}
