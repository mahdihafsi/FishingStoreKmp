package presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.HomeScreenData
import data.model.mockHomeScreenData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Définition de l'état de l'écran
data class HomeState(
    val data: HomeScreenData? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadHomeScreenData()
    }

    private fun loadHomeScreenData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            // Simulation d'un appel réseau ou de base de données
            kotlinx.coroutines.delay(1000) // Délai pour simuler le chargement

            // Utilisation des données mock pour l'exemple
            _state.value = _state.value.copy(
                data = mockHomeScreenData,
                isLoading = false
            )

            // En cas d'erreur (exemple)
            /*
            _state.value = _state.value.copy(
                isLoading = false,
                error = "Erreur de chargement des données."
            )
            */
        }
    }

    // Fonction pour rafraîchir les données
    fun refreshData() {
        loadHomeScreenData()
    }
}
