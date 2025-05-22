package ar.edu.uade.c012025.animeapp.ui.screens.animedetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AnimeDetailScreenViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository()
) : ViewModel() {
    var uiState by mutableStateOf(AnimeDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchAnime() {
        fetchJob?.cancel()
        fetchJob= viewModelScope.launch {
            uiState= uiState.copy(animeId = uiState.animeId, animeDetail = animeRepository.fetchAnime(uiState.animeId))
        }
    }

    fun setAnimeId(animeId: Int): Unit {
        uiState= uiState.copy(animeId= animeId, animeDetail = uiState.animeDetail)
        fetchAnime()
    }

}