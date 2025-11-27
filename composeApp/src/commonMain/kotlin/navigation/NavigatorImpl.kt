package navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/** Implémentation simple de Navigator en utilisant une pile interne */
class NavigatorImpl(start: Screen) : Navigator {
    private val stack = ArrayDeque<Screen>().apply { addLast(start) }
    private val _current = MutableStateFlow<Screen>(start)
    override val current: StateFlow<Screen> = _current

    override fun push(screen: Screen) {
        stack.addLast(screen)
        _current.value = screen
    }

    override fun pop(): Boolean {
        if (stack.size <= 1) return false
        stack.removeLast()
        _current.value = stack.last()
        return true
    }

    override fun replace(screen: Screen) {
        if (stack.isEmpty()) {
            stack.addLast(screen)
        } else {
            stack.removeLast()
            stack.addLast(screen)
        }
        _current.value = screen
    }
}

