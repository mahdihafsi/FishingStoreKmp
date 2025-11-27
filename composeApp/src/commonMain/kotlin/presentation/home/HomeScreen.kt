package presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.HomeScreenData
import navigation.Navigator
import ui.components.BottomNavigationBar
import ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigator: Navigator,
    viewModel: HomeViewModel = HomeViewModel()
) {
    AppTheme {
        val state by viewModel.state.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Home",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Action pour le menu sandwich */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Action pour la recherche */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Recherche"
                            )
                        }
                    },
                            colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background
                            )
                )
            },
            // La BottomBar sera ajoutée dans une phase ultérieure
            bottomBar = {
                BottomNavigationBar(
                    onItemSelected = { navItem ->
                        // Logique de navigation à implémenter ici (par exemple, avec un NavController)
                        println("Navigation vers: ${navItem.route}")
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                when {
                    state.isLoading -> {
                        // État de chargement
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                    state.error != null -> {
                        // État d'erreur
                        Text(
                            text = "Erreur: ${state.error}",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.align(Alignment.Center).padding(16.dp)
                        )
                    }
                    state.data != null -> {
                        // Contenu principal de l'écran d'accueil
                        HomeContent(state.data!!)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeContent(data: HomeScreenData) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // Permet le défilement vertical
    ) {
        // 1. Barre de Catégories (Header Navbar)
//        CategoryBar(data.categoryItems)

        // 2. Bannière Promotionnelle
        BannerSection(data.bannerItems)

        // 3. Produits Phares
        FeaturedProductsSection(data.productItems)

        // 4. Section Vidéos
        // Le padding horizontal est géré à l'intérieur des sections pour les LazyRow
        VideoSection(data.videoItems)

        // 5. Section Catalogues Pêche
        CatalogSection(data.catalogItems)
    }
}