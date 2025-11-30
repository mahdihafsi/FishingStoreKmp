package navigation

/** Classe scellée représentant les écrans de l'application */
sealed class Screen {
    // Représentation string de la route (utile pour deep links, persistance, analytics)
    abstract val route: String

    object Home : Screen() {
        override val route: String = "home"
    }

    data class Detail(val id: String) : Screen() {
        override val route: String = "detail/$id"
    }

    companion object {
        /**
         * Convertit une route string en Screen si possible.
         * Pattern simple: "home" ou "detail/{id}".
         */
        fun fromRoute(route: String): Screen? {
            return when {
                route == Home.route -> Home
                route.startsWith("detail/") -> {
                    val id = route.removePrefix("detail/")
                    if (id.isEmpty()) null else Detail(id)
                }
                else -> null
            }
        }
    }
}
