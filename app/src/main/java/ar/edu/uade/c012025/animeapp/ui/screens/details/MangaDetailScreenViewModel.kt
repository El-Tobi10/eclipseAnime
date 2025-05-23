package ar.edu.uade.c012025.animeapp.ui.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.MangaRepository
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MangaDetailScreenViewModel (
    private val mangaRepository: IMangaRepository = MangaRepository()
) : ViewModel() {
    var uiState by mutableStateOf(MangaDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchManga() {
        fetchJob?.cancel()
        fetchJob= viewModelScope.launch {
            uiState= uiState.copy(mangaId = uiState.mangaId, mangaDetail = mangaRepository.fetchManga(uiState.mangaId))
        }
    }

    fun setMangaId(mangaId: Int): Unit {
        uiState= uiState.copy(mangaId = mangaId, mangaDetail = uiState.mangaDetail)
        fetchManga()
    }

    var characterList by mutableStateOf<List<CharacterData>>(emptyList())
        private set

    fun loadCharacters(mangaId: Int) {
        viewModelScope.launch {
            characterList = mangaRepository.fetchCharacters(mangaId)
        }
    }

    var recommendationList by mutableStateOf<List<Manga>>(emptyList())
        private set

    fun loadRecommendations(mangaId: Int) {
        viewModelScope.launch {
            recommendationList = mangaRepository.fetchRecommendations(mangaId)
        }
    }

}