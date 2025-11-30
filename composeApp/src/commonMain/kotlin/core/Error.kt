package core

// DomainError étend Throwable pour faciliter le passage d'erreurs et la compatibilité avec Result
sealed class DomainError(message: String? = null) : Throwable(message)

object NetworkError : DomainError()

data class UnknownError(val info: String?) : DomainError(info)
