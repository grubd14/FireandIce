package com.example.fireandice.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fireandice.network.CharacterApi
import kotlinx.coroutines.launch
import java.io.IOException



sealed interface CharacterUiState {
    data class Success(val thrones: String) : CharacterUiState
    object Error : CharacterUiState
    object Loading : CharacterUiState
}

class CharacterViewModel : ViewModel() {
    var characterUiState: CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set


    init {
        getThronesCharacters()
    }

    private fun getThronesCharacters() {
        viewModelScope.launch {
            try {
                val listResult = CharacterApi.retrofitService.getCharacters()
                characterUiState = CharacterUiState.Success("Success: ${listResult.size} Characters retrieved")
            } catch (e:IOException) {
                CharacterUiState.Error
            }
        }
    }
}