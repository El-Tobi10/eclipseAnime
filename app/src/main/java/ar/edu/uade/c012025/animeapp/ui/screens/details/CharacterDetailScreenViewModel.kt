package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.CharacterRepository
import ar.edu.uade.c012025.animeapp.domain.ICharacterRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharacterDetailScreenViewModel (
    private val characterRepository: ICharacterRepository = CharacterRepository()
) : ViewModel(){
    var uiState by mutableStateOf(CharacterDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchCharacter() {
        Log.d("CharacterViewModel", "Inicio fetchCharacter() ID: ${uiState.characterId}")
        fetchJob?.cancel()
        fetchJob= viewModelScope.launch {
            try {
            delay(1000)
                Log.d("CharacterViewModel", "Llamando a repository...")
                uiState= uiState.copy(characterId = uiState.characterId, characterDetail = characterRepository.fetchCharacter(uiState.characterId))
                Log.d("CharacterViewModel", "Personaje obtenido: ${uiState.characterDetail.name}")
            } catch (e: Exception) {
                Log.e("CharacterViewModel", "Error al obtener el personaje", e)
            }
        }
    }

    fun setCharacterId(characterId: Int): Unit {
        uiState= uiState.copy(characterId= characterId, characterDetail = uiState.characterDetail)
        fetchCharacter()
    }
}