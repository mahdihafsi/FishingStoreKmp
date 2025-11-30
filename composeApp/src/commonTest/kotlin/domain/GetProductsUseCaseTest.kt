package domain

//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlinx.coroutines.runBlocking
//import domain.usecase.GetProductsUseCase
//import domain.repository.ProductRepository
//import domain.model.Product
//import core.Result
//
//class FakeRepo(private val items: List<Product>) : ProductRepository {
//    override suspend fun getProducts(): Result<List<Product>> = Result.Success(items)
//}
//
//class GetProductsUseCaseTest {
//    @Test
//    fun `use case returns products from repository`() = runBlocking {
//        val products = listOf(Product("1", "Rod", 10.0))
//        val repo = FakeRepo(products)
//        val uc = GetProductsUseCase(repo)
//        val result = uc()
//        when (result) {
//            is Result.Success -> assertEquals(products, result.data)
//            else -> throw AssertionError("Expected Success")
//        }
//    }
//}

