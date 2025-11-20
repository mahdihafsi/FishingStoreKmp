package org.example.fishingstore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform