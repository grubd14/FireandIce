package com.example.fireandice

import android.app.Application
import com.example.fireandice.data.AppContainer
import com.example.fireandice.data.DefaultAppContainer

class CharacterApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}