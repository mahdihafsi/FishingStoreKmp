package org.example.fishingstore

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import navigation.NavigatorImpl
import navigation.Screen
import presentation.ui.AppNavHost

@Composable
@Preview
fun App() {
    // Initialise le navigator avec l'écran de démarrage
    val navigator = NavigatorImpl(start = Screen.Home)

    AppNavHost(navigator = navigator)
}