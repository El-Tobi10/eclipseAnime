package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.data.GenresRepository
import ar.edu.uade.c012025.animeapp.data.MangaRepository
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.data.SearchScreenState
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import ar.edu.uade.c012025.animeapp.domain.IGenresRepository
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class SearchViewModel(
    context : Context,
    private val animeRepository: IAnimeRepository = AnimeRepository(context),
    private val mangaRepository: IMangaRepository = MangaRepository(context),
    private val genreRepository: IGenresRepository = GenresRepository(),
) : ViewModel() {

    var uiState by mutableStateOf(SearchScreenState())
        private set
    var selectedGenreId by mutableStateOf<Int?>(null)
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
                            imageUrl = it.images?.jpg?.imageUrl.toString(),
                            type = SearchItemType.ANIME
                        )
                    }

                val mangas = mangaRepository.fetchMangas(uiState.searchQuery)
                    .map {
                        SearchItem(
                            id = it.id,
                            title = it.title,
                            imageUrl = it.images.jpg?.imageUrl.toString(),
                            type = SearchItemType.MANGA
                        )
                    }

                uiState = uiState.copy(searchResults = animes + mangas)
            } catch (e: IOException) {
                Log.e("Search", "Error recuperando resultados", e)
            }
        }
    }
    fun fetchByGenre(genreId: Int) {
        viewModelScope.launch {
            val animeResults = genreRepository.getAnimeByGenre(genreId)
                .map {
                SearchItem(
                    id = it.id,
                    title = it.title,
                    imageUrl = it.images?.jpg?.imageUrl,
                    type = SearchItemType.ANIME
                )
            }
            val mangaResults = genreRepository.getMangaByGenre(genreId)
                .map {
                SearchItem(
                    id = it.id,
                    title = it.title,
                    imageUrl = it.images.jpg?.imageUrl,
                    type = SearchItemType.MANGA
                )
            }
            uiState = uiState.copy(searchResults = animeResults + mangaResults)
        }
    }

    fun selectGenre(genreId: Int) {
        selectedGenreId = genreId
    }

    fun searchChange(search: String) {
        uiState = uiState.copy(searchQuery = search)
    }
}
