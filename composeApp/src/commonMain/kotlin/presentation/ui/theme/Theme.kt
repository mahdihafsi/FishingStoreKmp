package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import presentation.ui.theme.Shapes
import presentation.ui.theme.Typography

// Définition des couleurs pour le thème clair
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00695C), // Vert foncé pour l'accentuation (inspiré de la pêche/nature)
    onPrimary = Color.White,
    primaryContainer = Color(0xFF84F8E0),
    onPrimaryContainer = Color(0xFF00201B),
    secondary = Color(0xFF4C635C), // Couleur secondaire
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFCFE9DE),
    onSecondaryContainer = Color(0xFF09201A),
    tertiary = Color(0xFF406378), // Couleur tertiaire (bleu pour l'eau)
    onTertiary = Color.White,
    background = Color(0xFFFBFDFB),
    onBackground = Color(0xFF191C1B),
    surface = Color(0xFFFBFDFB),
    onSurface = Color(0xFF191C1B),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    // Utilisation du gris clair pour les surfaces d'arrière-plan des cartes
    surfaceContainer = Color(0xFFEFEFEF)
)

// Définition des couleurs pour le thème sombre
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF67DBCA),
    onPrimary = Color(0xFF003730),
    primaryContainer = Color(0xFF005046),
    onPrimaryContainer = Color(0xFF84F8E0),
    secondary = Color(0xFFB3CCC2),
    onSecondary = Color(0xFF1F352F),
    secondaryContainer = Color(0xFF354B45),
    onSecondaryContainer = Color(0xFFCFE9DE),
    tertiary = Color(0xFF9FCBE4),
    onTertiary = Color(0xFF0C3448),
    background = Color(0xFF191C1B),
    onBackground = Color(0xFFE1E3E1),
    surface = Color(0xFF191C1B),
    onSurface = Color(0xFFE1E3E1),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    // Utilisation du gris foncé pour les surfaces d'arrière-plan des cartes
    surfaceContainer = Color(0xFF2C2C2C)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Utilisation de la typographie définie dans Typography.kt
        shapes = Shapes, // Utilisation des formes définies dans Shape.kt
        content = content
    )
}
