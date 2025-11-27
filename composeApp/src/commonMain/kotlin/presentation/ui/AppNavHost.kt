package presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import navigation.Navigator
import navigation.Screen
import presentation.screens.DetailScreen
import presentation.home.HomeScreen

/** Hôte de navigation simple: observe le navigator et affiche le composable correspondant */
@Composable
fun AppNavHost(navigator: Navigator, modifier: Modifier = Modifier) {
    val screen by navigator.current.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        when (screen) {
            is Screen.Home -> HomeScreen(navigator)
            is Screen.Detail -> {
                val id = (screen as Screen.Detail).id
                DetailScreen(navigator, id)
            }
        }
    }
}
