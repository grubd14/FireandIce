package com.example.fireandice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fireandice.ui.ThronesApp
import com.example.fireandice.ui.screens.CharacterViewModel
import com.example.fireandice.ui.theme.FireAndIceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireAndIceTheme {
                val viewModel: CharacterViewModel = viewModel(factory = CharacterViewModel.Factory)
                ThronesApp()

            }
        }

    }
}

