package presentation.store

import domain.model.Product
import domain.usecase.GetProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import core.Result

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val scope: CoroutineScope = MainScope()
) {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        scope.launch {
            when (val r = getProductsUseCase()) {
                is Result.Success -> _products.value = r.data
                is Result.Failure -> {
                    // handle error later; keep list empty for now
                }
            }
        }
    }
}
