package di

import data.repository.InMemoryProductRepository
import domain.usecase.GetProductsUseCase
import navigation.Navigator
import navigation.NavigatorImpl
import navigation.Screen

object ServiceLocator {
    private val productRepository by lazy { InMemoryProductRepository() }
    fun provideGetProductsUseCase(): GetProductsUseCase = GetProductsUseCase(productRepository)

    // Provide a navigator singleton for the app (utilise l'implémentation portable)
    val navigator: Navigator by lazy { NavigatorImpl(Screen.Home) }
}
