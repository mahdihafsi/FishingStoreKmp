package org.example.fishingstore.navigation

import navigation.NavigatorImpl
import navigation.Screen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NavigatorTest {
    @Test
    fun pushAndPop() {
        val nav = NavigatorImpl(start = Screen.Home)
        assertEquals(Screen.Home::class, nav.current.value::class)

        nav.push(Screen.Detail("1"))
        assertEquals(Screen.Detail::class, nav.current.value::class)

        val popped = nav.pop()
        assertTrue(popped)
        assertEquals(Screen.Home::class, nav.current.value::class)
    }

    @Test
    fun popAtRootReturnsFalse() {
        val nav = NavigatorImpl(start = Screen.Home)
        val popped = nav.pop()
        assertFalse(popped)
        assertEquals(Screen.Home::class, nav.current.value::class)
    }

    @Test
    fun replaceReplacesTop() {
        val nav = NavigatorImpl(start = Screen.Home)
        nav.push(Screen.Detail("1"))
        nav.replace(Screen.Detail("2"))
        assertEquals("2", (nav.current.value as Screen.Detail).id)
    }
}
