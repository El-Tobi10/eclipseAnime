package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.localdata.toCharacterExternal
import ar.edu.uade.c012025.animeapp.data.localdata.toCharacterLocal
import ar.edu.uade.c012025.animeapp.domain.ICharacterRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharacterDetailScreenViewModel (
    private val characterRepository: ICharacterRepository
) : ViewModel(){
    var uiState by mutableStateOf(CharacterDetailScreenState())
        private set
    var character by mutableStateOf<CharacterData?>(null)
        private set

    fun loadCharacter(characterId: Int) {
        viewModelScope.launch {
            Log.d("CharacterVM", "Inicia loadCharacter con ID $characterId")

            try {
                val localEntity = characterRepository.getCharacterById(characterId)
                Log.d("CharacterVM", "Resultado local: $localEntity")

                if (localEntity != null) {
                    character = localEntity.toCharacterExternal()
                    Log.d("CharacterVM", "Cargado desde ROOM: ${character?.name}")
                } else {
                    val remoteCharacter = characterRepository.fetchCharacter(characterId)
                    character = remoteCharacter
                    characterRepository.insertCharacter(remoteCharacter.toCharacterLocal())
                    Log.d("CharacterVM", "Cargado desde API y guardado local")
                }

            } catch (e: Exception) {
                Log.e("CharacterVM", "Error en loadCharacter", e)
            }
        }
    }

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