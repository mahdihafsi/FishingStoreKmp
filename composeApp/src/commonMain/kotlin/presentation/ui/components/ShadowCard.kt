package presentation.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.ui.theme.Shapes

/**
 * Carte réutilisable avec les styles Material 3 (coins arrondis et élévation/shadow).
 */
@Composable
fun ShadowCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = Shapes.medium, // Utilisation de la forme définie (12.dp)
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Ajout d'une ombre (shadow)
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer // Utilisation d'une couleur de surface légèrement différente
        ),
        content = content
    )
}
