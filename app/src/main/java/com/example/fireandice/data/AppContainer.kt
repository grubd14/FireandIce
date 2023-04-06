package com.example.fireandice.data

import com.example.fireandice.network.CharacterApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val characterRepository: CharacterRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://thronesapi.com/api/v2/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }

    override val characterRepository: CharacterRepository by lazy {
        DefaultCharacterRepository(retrofitService)
    }

}