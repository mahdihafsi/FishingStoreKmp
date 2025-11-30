package navigation

import kotlinx.coroutines.flow.StateFlow

/** Interface légère pour la navigation stack-based, testable en commonMain */
interface Navigator {
    val current: StateFlow<Screen>
    fun push(screen: Screen)
    fun pop(): Boolean
    fun replace(screen: Screen)
}

