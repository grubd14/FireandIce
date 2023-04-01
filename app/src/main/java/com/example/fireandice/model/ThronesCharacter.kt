package com.example.fireandice.model

import kotlinx.serialization.Serializable


@Serializable
data class Character(
    val id: String,
    val firstName: String,
    val lastName: String,
    val fullName : String,
    val title: String,
    val family: String,
    val image: String,
    val imageUrl: String
)
