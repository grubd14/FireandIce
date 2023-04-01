package com.example.fireandice.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://thronesapi.com/api/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface CharacterApiService {
    @GET("Characters")
    suspend fun getCharacters(): String
}

object CharacterApi {
    val retrofitService: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}