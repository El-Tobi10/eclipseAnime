package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.data.MangaRepository
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.data.SearchScreenState
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class SearchViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository(),
    private val mangaRepository: IMangaRepository = MangaRepository()
) : ViewModel() {

    var uiState by mutableStateOf(SearchScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchResults() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val animes = animeRepository.fetchAnimes(uiState.searchQuery)
                    .map {
                        SearchItem(
                            id = it.id,
                            title = it.title,
                            imageUrl = it.images.jpg.imageUrl,
                            type = SearchItemType.ANIME
                        )
                    }

                val mangas = mangaRepository.fetchMangas(uiState.searchQuery)
                    .map {
                        SearchItem(
                            id = it.id,
                            title = it.title,
                            imageUrl = it.images.jpg.imageUrl,
                            type = SearchItemType.MANGA
                        )
                    }

                uiState = uiState.copy(searchResults = animes + mangas)
            } catch (e: IOException) {
                Log.e("Search", "Error recuperando resultados", e)
            }
        }
    }

    fun searchChange(search: String) {
        uiState = uiState.copy(searchQuery = search)
    }
}
