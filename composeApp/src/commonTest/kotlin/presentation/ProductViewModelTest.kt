package presentation
//
//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlinx.coroutines.test.runTest
//import domain.model.Product
//import domain.repository.ProductRepository
//import domain.usecase.GetProductsUseCase
//import core.Result
//import presentation.store.ProductViewModel
//
//class FakeRepo(private val items: List<Product>) : ProductRepository {
//    override suspend fun getProducts(): Result<List<Product>> = Result.Success(items)
//}
//
//class ProductViewModelTest {
//    @Test
//    fun `viewModel loads products from use case`() = runTest {
//        val products = listOf(Product("1", "Rod", 10.0))
//        val repo = FakeRepo(products)
//        val uc = GetProductsUseCase(repo)
//        val vm = ProductViewModel(uc, this)
//        // ensure launched coroutines finish
//        this.advanceUntilIdle()
//        assertEquals(products, vm.products.value)
//    }
//}

