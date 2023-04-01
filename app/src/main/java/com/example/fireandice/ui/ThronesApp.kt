package com.example.fireandice.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fireandice.R
import com.example.fireandice.ui.screens.CharacterViewModel
import com.example.fireandice.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThronesApp(modifier: Modifier = Modifier) {
    Scaffold (
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = {
            Text(stringResource(R.string.app_name)) }) }
    ){
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ){
            val characterViewModel : CharacterViewModel = viewModel()
            HomeScreen(
                characterUiState = characterViewModel.characterUiState,
            )
        }
    }
}


