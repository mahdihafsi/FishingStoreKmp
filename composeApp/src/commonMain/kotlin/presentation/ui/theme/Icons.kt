package presentation.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin


// Mapping des noms d'icônes (utilisés dans HomeData.kt) aux icônes réelles de Compose
fun getIconByName(name: String): ImageVector {
    return when (name) {
        "home" -> Icons.Filled.Home
        "newspaper" -> Newspaper
        "cloud_download" -> Cloud_download
        "bookmarks" -> Icons.Filled.Star
        "menu" -> Icons.Filled.Menu
        else -> Icons.Filled.Home // Icône par défaut
    }
}



val Cloud_download: ImageVector
    get() {
        if (_Cloud_download != null) return _Cloud_download!!

        _Cloud_download = ImageVector.Builder(
            name = "Cloud_download",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(260f, 800f)
                quadToRelative(-91f, 0f, -155.5f, -63f)
                reflectiveQuadTo(40f, 583f)
                quadToRelative(0f, -78f, 47f, -139f)
                reflectiveQuadToRelative(123f, -78f)
                quadToRelative(17f, -72f, 85f, -137f)
                reflectiveQuadToRelative(145f, -65f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(520f, 244f)
                verticalLineToRelative(242f)
                lineToRelative(64f, -62f)
                lineToRelative(56f, 56f)
                lineToRelative(-160f, 160f)
                lineToRelative(-160f, -160f)
                lineToRelative(56f, -56f)
                lineToRelative(64f, 62f)
                verticalLineToRelative(-242f)
                quadToRelative(-76f, 14f, -118f, 73.5f)
                reflectiveQuadTo(280f, 440f)
                horizontalLineToRelative(-20f)
                quadToRelative(-58f, 0f, -99f, 41f)
                reflectiveQuadToRelative(-41f, 99f)
                reflectiveQuadToRelative(41f, 99f)
                reflectiveQuadToRelative(99f, 41f)
                horizontalLineToRelative(480f)
                quadToRelative(42f, 0f, 71f, -29f)
                reflectiveQuadToRelative(29f, -71f)
                reflectiveQuadToRelative(-29f, -71f)
                reflectiveQuadToRelative(-71f, -29f)
                horizontalLineToRelative(-60f)
                verticalLineToRelative(-80f)
                quadToRelative(0f, -48f, -22f, -89.5f)
                reflectiveQuadTo(600f, 280f)
                verticalLineToRelative(-93f)
                quadToRelative(74f, 35f, 117f, 103.5f)
                reflectiveQuadTo(760f, 440f)
                quadToRelative(69f, 8f, 114.5f, 59.5f)
                reflectiveQuadTo(920f, 620f)
                quadToRelative(0f, 75f, -52.5f, 127.5f)
                reflectiveQuadTo(740f, 800f)
                close()
                moveToRelative(220f, -358f)
            }
        }.build()

        return _Cloud_download!!
    }

private var _Cloud_download: ImageVector? = null






val Newspaper: ImageVector
    get() {
        if (_Newspaper != null) return _Newspaper!!

        _Newspaper = ImageVector.Builder(
            name = "Newspaper",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF0F172A)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 7.5f)
                horizontalLineTo(13.5f)
                moveTo(12f, 10.5f)
                horizontalLineTo(13.5f)
                moveTo(6f, 13.5f)
                horizontalLineTo(13.5f)
                moveTo(6f, 16.5f)
                horizontalLineTo(13.5f)
                moveTo(16.5f, 7.5f)
                horizontalLineTo(19.875f)
                curveTo(20.4963f, 7.5f, 21f, 8.00368f, 21f, 8.625f)
                verticalLineTo(18f)
                curveTo(21f, 19.2426f, 19.9926f, 20.25f, 18.75f, 20.25f)
                moveTo(16.5f, 7.5f)
                verticalLineTo(18f)
                curveTo(16.5f, 19.2426f, 17.5074f, 20.25f, 18.75f, 20.25f)
                moveTo(16.5f, 7.5f)
                verticalLineTo(4.875f)
                curveTo(16.5f, 4.25368f, 15.9963f, 3.75f, 15.375f, 3.75f)
                horizontalLineTo(4.125f)
                curveTo(3.50368f, 3.75f, 3f, 4.25368f, 3f, 4.875f)
                verticalLineTo(18f)
                curveTo(3f, 19.2426f, 4.00736f, 20.25f, 5.25f, 20.25f)
                horizontalLineTo(18.75f)
                moveTo(6f, 7.5f)
                horizontalLineTo(9f)
                verticalLineTo(10.5f)
                horizontalLineTo(6f)
                verticalLineTo(7.5f)
                close()
            }
        }.build()

        return _Newspaper!!
    }

private var _Newspaper: ImageVector? = null





