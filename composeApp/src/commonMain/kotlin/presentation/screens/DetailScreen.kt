package presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import di.ServiceLocator
import navigation.Navigator
import core.Result

@Composable
fun DetailScreen(navigator: Navigator, id: String) {
    val productState = remember { mutableStateOf<Pair<String, Double>?>(null) }

    LaunchedEffect(id) {
        val uc = ServiceLocator.provideGetProductsUseCase()
        when (val r = uc()) {
            is Result.Success -> {
                val found = r.data.find { it.id == id }
                if (found != null) productState.value = Pair(found.name, found.price)
            }
            is Result.Failure -> {
                // ignore for now
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        val p = productState.value
        if (p == null) {
            Text("Loading...", style = MaterialTheme.typography.bodyMedium)
        } else {
            Text("${p.first}", style = MaterialTheme.typography.headlineSmall)
            Text("\u20AC${p.second}", style = MaterialTheme.typography.titleMedium)
            Button(onClick = { navigator.pop() }, modifier = Modifier.padding(top = 12.dp)) {
                Text("Back")
            }
        }
    }
}
