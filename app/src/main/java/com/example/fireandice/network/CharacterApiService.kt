package com.example.fireandice.network


import com.example.fireandice.model.Character
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://thronesapi.com/api/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()


interface CharacterApiService {
    @GET("Characters")
    suspend fun getCharacters(): List<Character>
}

object CharacterApi {
    val retrofitService: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}