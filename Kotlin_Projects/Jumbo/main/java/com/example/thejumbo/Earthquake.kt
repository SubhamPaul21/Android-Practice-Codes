package com.example.thejumbo

data class Earthquake(
    val magnitude: Double, val offset: String, val location: String,
    val milliseconds: Long, val url: String
)
