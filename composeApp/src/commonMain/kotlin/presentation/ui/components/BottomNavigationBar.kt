package ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import data.model.BottomNavItem
import presentation.ui.theme.getIconByName

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onItemSelected: (BottomNavItem) -> Unit = {}
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
        BottomNavItem.Library,
        BottomNavItem.Bookmarks,
        BottomNavItem.More
    )
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }

    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface, // Utilisation de la couleur de surface pour la barre
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        items.forEach { item ->
            val isSelected = item == selectedItem
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = getIconByName(item.iconName),
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = isSelected,
                onClick = {
                    selectedItem = item
                    onItemSelected(item)
                },
                alwaysShowLabel = true,
                colors = androidx.compose.material3.NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}
