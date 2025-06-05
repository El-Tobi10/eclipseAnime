package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.data.Character
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AnimeDetailScreenViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository(),
    private val favoritesRepository: FavoritesRepository = FavoritesRepository()
) : ViewModel() {
    var uiState by mutableStateOf(AnimeDetailScreenState())
        private set
    var isFavorite by mutableStateOf(false)
        private set

    private var fetchJob: Job? = null

    fun fetchAnime() {
        fetchJob?.cancel()
        fetchJob= viewModelScope.launch {
            try{
                delay(500)
                Log.e("AnimeViewModel", "Inicio fetchAnime() ID: ${uiState.animeId}")
                uiState= uiState.copy(animeId = uiState.animeId, animeDetail = animeRepository.fetchAnime(uiState.animeId))
            } catch (e: Exception) {
                Log.e("AnimeViewModel", "Error al obtener el anime", e)
            }

        }
    }

    fun setAnimeId(animeId: Int): Unit {
        uiState= uiState.copy(animeId= animeId, animeDetail = uiState.animeDetail)
        fetchAnime()
    }

    var characterList by mutableStateOf<List<Character>>(emptyList())
        private set

    fun loadCharacters(animeId: Int) {
        viewModelScope.launch {
            characterList = animeRepository.fetchCharacters(animeId)
        }
    }

    var recommendationList by mutableStateOf<List<Anime>>(emptyList())
        private set

    fun loadRecommendations(animeId: Int) {
        viewModelScope.launch {
            recommendationList = animeRepository.fetchRecommendations(animeId)
        }
    }

    fun checkFavorite(email: String, item: SearchItem) {
        viewModelScope.launch {
            isFavorite = favoritesRepository.isFavorite(email, item)
        }
    }

    fun toggleFavorite(email: String, item: SearchItem) {
        viewModelScope.launch {
            favoritesRepository.toggleFavorite(email, item)
            isFavorite = !isFavorite
        }
    }

}