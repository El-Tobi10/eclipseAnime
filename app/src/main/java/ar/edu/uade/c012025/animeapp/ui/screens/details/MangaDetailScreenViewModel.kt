package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Character
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.MangaRepository
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.localdata.toExternal
import ar.edu.uade.c012025.animeapp.data.localdata.toLocal
import ar.edu.uade.c012025.animeapp.data.localdata.toMangaExternal
import ar.edu.uade.c012025.animeapp.data.localdata.toMangaLocal
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MangaDetailScreenViewModel (
    private val mangaRepository: IMangaRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {
    var uiState by mutableStateOf(MangaDetailScreenState())
        private set
    var isFavorite by mutableStateOf(false)
        private set
    var manga by mutableStateOf<Manga?>(null)
        private set

    fun loadManga(mangaId: Int) {
        viewModelScope.launch {
            Log.d("MangaVM", "Inicia loadManga con ID $mangaId")

            try {
                val localEntity = mangaRepository.getMangaById(mangaId)
                Log.d("MangaVM", "Resultado local: $localEntity")

                if (localEntity != null) {
                    manga = localEntity.toMangaExternal()
                    Log.d("MangaVM", "Cargado desde ROOM: ${manga?.title}")
                } else {
                    val remoteManga = mangaRepository.fetchManga(mangaId)
                    manga = remoteManga
                    mangaRepository.insertManga(remoteManga.toMangaLocal())
                    Log.d("MangaVM", "Cargado desde API y guardado local")
                }

            } catch (e: Exception) {
                Log.e("MangaVM", "Error en loadManga", e)
            }
        }
    }


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

    var characterList by mutableStateOf<List<Character>>(emptyList())
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