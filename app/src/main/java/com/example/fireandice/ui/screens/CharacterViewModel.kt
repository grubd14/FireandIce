package com.example.fireandice.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fireandice.CharacterApplication
import com.example.fireandice.data.CharacterRepository
import com.example.fireandice.model.Character
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException



sealed interface CharacterUiState {
    data class Success(val thrones: List<Character>) : CharacterUiState
    object Error : CharacterUiState
    object Loading : CharacterUiState
}

class CharacterViewModel(private val characterRepository: CharacterRepository) : ViewModel() {
    var characterUiState: CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set


    init {
        getThronesCharacters()
    }

    private fun getThronesCharacters() {
        viewModelScope.launch {
            characterUiState = try {
                CharacterUiState.Success(characterRepository.getThronesCharacter())
            } catch (e:IOException) {
                CharacterUiState.Error
            } catch (e: HttpException) {
                CharacterUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CharacterApplication)
                val characterRepository = application.container.characterRepository
                CharacterViewModel(characterRepository = characterRepository)
            }
        }
    }
}