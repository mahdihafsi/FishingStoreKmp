package presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import data.model.VideoItem
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.ui.components.ShadowCard

// Placeholder pour simuler le chargement d'image
@OptIn(ExperimentalResourceApi::class)
@Composable
fun PlaceholderImage(modifier: Modifier = Modifier, imageUrl: String) {
    // Dans un vrai projet KMM, vous utiliseriez une librairie comme Coil/Kamel pour charger l'image depuis l'URL
    // Ici, nous utilisons un simple Box avec une couleur pour simuler l'image
    Box(
        modifier = modifier
            .background(Color.LightGray)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        // Simulation de l'image de la capture d'écran
        if (imageUrl.contains("video_1")) {
            // Utilisation d'une image locale pour simuler le contenu de la vidéo
            // NOTE: Cette ressource doit exister dans le dossier 'composeResources/drawable'
            // Pour l'exemple, nous allons simuler l'image avec un Box coloré et du texte
            Text("Image Vidéo", color = Color.White)
        } else {
            Text("Image Vidéo", color = Color.White)
        }
    }
}

@Composable
fun VideoSection(videos: List<VideoItem>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Videos",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(onClick = { /* Action "SHOW ALL" */ }) {
            Text("SHOW ALL", style = MaterialTheme.typography.labelMedium)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(videos) { video ->
            VideoCard(video)
        }
    }
}

@Composable
fun VideoCard(video: VideoItem) {
    ShadowCard(
        modifier = Modifier
            .width(280.dp) // Largeur fixe pour la carte vidéo
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // 1. Image de la vidéo
            PlaceholderImage(
                modifier = Modifier.fillMaxSize(),
                imageUrl = video.imageUrl
            )

            // 2. Gradient pour le texte
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f) // Le gradient couvre le bas de l'image
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                            startY = 0f,
                            endY = 200f
                        )
                    )
            )

            // 3. Texte et Source
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                // Source (Cot&Pêche)
                Text(
                    text = video.source,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White.copy(alpha = 0.7f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Titre de la vidéo
                Text(
                    text = video.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    maxLines = 2
                )
            }

            // 4. Icône Play (optionnel, pour un effet plus "vidéo")
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White.copy(alpha = 0.9f),
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
