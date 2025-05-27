package ar.edu.uade.c012025.animeapp.ui.screens.index

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.data.TopRepositoy
import ar.edu.uade.c012025.animeapp.domain.ITopRepository
import kotlinx.coroutines.launch
import java.io.IOException

data class HomeScreenState(
    val lastEpisodes: List<SearchItem> = emptyList(),
    val topAnimes: List<SearchItem> = emptyList(),
    val topMangas: List<SearchItem> = emptyList()
)

class HomeViewModel(
    private val topRepository: ITopRepository = TopRepositoy()
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
        private set

    init {
        fetchTopItems()
    }

    private fun fetchTopItems() {
        viewModelScope.launch {
            try {
                val lastEpisodes = topRepository.fetchLastEpisodes().flatMap { episodes ->
                    episodes.episodes.map { ep ->
                        SearchItem(
                            id = episodes.entry.id,
                            title = "${ep.title} (${episodes.entry.title})",
                            imageUrl = episodes.entry.images.jpg?.imageUrl.toString(),
                            type = SearchItemType.EPISODE
                        )
                    }
                }
                val topAnimes = topRepository.fetchTopAnime().map {
                    SearchItem(
                        id = it.id,
                        title = it.title,
                        imageUrl = it.images?.jpg?.imageUrl.toString(),
                        type = SearchItemType.ANIME
                    )
                }

                val topMangas = topRepository.fetchTopManga().map {
                    SearchItem(
                        id = it.id,
                        title = it.title,
                        imageUrl = it.images.jpg?.imageUrl.toString(),
                        type = SearchItemType.MANGA
                    )
                }

                uiState = uiState.copy(lastEpisodes = lastEpisodes, topAnimes = topAnimes, topMangas = topMangas)
            } catch (e: IOException) {
                Log.e("HomeViewModel", "Error cargando los tops", e)
            }
        }
    }
}