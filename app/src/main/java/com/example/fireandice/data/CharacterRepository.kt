package com.example.fireandice.data

import com.example.fireandice.model.Character
import com.example.fireandice.network.CharacterApiService

interface CharacterRepository {
    suspend fun getThronesCharacter(): List<Character>
}

class DefaultCharacterRepository(
    private val characterApiService: CharacterApiService
) : CharacterRepository {
    override suspend fun getThronesCharacter(): List<Character> {
        return characterApiService.getCharacters()
    }
}