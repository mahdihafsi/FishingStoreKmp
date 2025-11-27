package data.mappers

import data.model.ProductDto
import domain.model.Product

fun ProductDto.toDomain(): Product = Product(id = id, name = name, price = price)
fun Product.toDto(): ProductDto = ProductDto(id = id, name = name, price = price)

