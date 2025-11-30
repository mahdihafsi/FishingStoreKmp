package data.model

import kotlinx.serialization.Serializable

/**
 * Modèle de données pour un élément de la section Vidéos.
 */
@Serializable
data class VideoItem(
    val id: String,
    val title: String,
    val imageUrl: String,
    val source: String // e.g., "Cot&Pêche"
)

/**
 * Modèle de données pour un élément de la section Catalogues Pêche.
 */

/**
 * Modèle de données pour un élément de catégorie dans la barre de navigation d'en-tête.
 */
@Serializable
data class CategoryItem(
    val id: String,
    val title: String,
    val iconUrl: String? = null
)

/**
 * Modèle de données pour une bannière promotionnelle.
 */
@Serializable
data class BannerItem(
    val id: String,
    val imageUrl: String,
    val title: String,
    val subtitle: String? = null,
    val targetUrl: String
)

/**
 * Modèle de données pour un produit phare.
 */
@Serializable
data class ProductItem(
    val id: String,
    val name: String,
    val imageUrl: String,
    val price: String,
    val rating: Float? = null
)

/**
 * Modèle de données pour un élément de la section Catalogues Pêche.
 */
data class CatalogItem(
    val id: String,
    val title: String,
    val coverImageUrl: String,
    val year: Int
)

/**
 * Modèle de données pour la barre de navigation inférieure.
 */
sealed class BottomNavItem(val route: String, val title: String, val iconName: String) {
    data object Home : BottomNavItem("home", "Home", "home")
    data object News : BottomNavItem("news", "News", "newspaper")
    data object Library : BottomNavItem("library", "Library", "cloud_download")
    data object Bookmarks : BottomNavItem("bookmarks", "Bookmarks", "star")
    data object More : BottomNavItem("more", "More", "menu")
}

/**
 * Modèle de données agrégé pour l'écran d'accueil.
 */
data class HomeScreenData(
    val categoryItems: List<CategoryItem>,
    val bannerItems: List<BannerItem>,
    val productItems: List<ProductItem>,
    val videoItems: List<VideoItem>,
    val catalogItems: List<CatalogItem>
)

// Données de prévisualisation pour le développement
val mockVideoItems = listOf(
    VideoItem("v1", "Le SeaGame 250 X : un fishing américain à la mode italienne !", "url_video_1", "Cot&Pêche"),
    VideoItem("v2", "Test du nouveau moteur Mercury V10", "url_video_2", "Mercury Marine"),
    VideoItem("v3", "Techniques de pêche au bar en Atlantique", "url_video_3", "Pêche Passion")
)

val mockCatalogItems = listOf(
    CatalogItem("c1", "BKK 2026", "url_catalog_1", 2026),
    CatalogItem("c2", "Shimano 2025", "url_catalog_2", 2025),
    CatalogItem("c3", "Garmin Marine", "url_catalog_3", 2026)
)

val mockCategoryItems = listOf(
    CategoryItem("cat1", "Cannes", "icon_canne"),
    CategoryItem("cat2", "Moulinets", "icon_moulinet"),
    CategoryItem("cat3", "Leurres", "icon_leurre"),
    CategoryItem("cat4", "Vêtements", "icon_vetement"),
    CategoryItem("cat5", "Accessoires", "icon_accessoire")
)

val mockBannerItems = listOf(
    BannerItem("b1", "url_banner_1", "PROMO EXCLUSIVE", "Jusqu'à -50% sur les leurres", "url_promo_leurres"),
    BannerItem("b2", "url_banner_2", "Nouveautés 2026", "Découvrez les derniers modèles", "url_nouveautes")
)

val mockProductItems = listOf(
    ProductItem("p1", "Canne X-Treme Pro", "url_product_1", "199.99 €", 4.5f),
    ProductItem("p2", "Moulinet SeaMaster 3000", "url_product_2", "125.00 €", 4.8f),
    ProductItem("p3", "Leurre Popper Flottant", "url_product_3", "12.50 €", 4.2f)
)

val mockHomeScreenData = HomeScreenData(
    categoryItems = mockCategoryItems,
    bannerItems = mockBannerItems,
    productItems = mockProductItems,
    videoItems = mockVideoItems,
    catalogItems = mockCatalogItems
)
