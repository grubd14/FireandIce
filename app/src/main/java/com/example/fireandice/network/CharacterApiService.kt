package com.example.fireandice.network


import com.example.fireandice.model.Character
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface CharacterApiService {
    @GET("Characters")
    suspend fun getCharacters(): List<Character>
}
