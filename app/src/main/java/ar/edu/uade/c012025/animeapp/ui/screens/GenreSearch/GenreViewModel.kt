package ar.edu.uade.c012025.animeapp.ui.screens.GenreSearch

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.GenreData
import ar.edu.uade.c012025.animeapp.data.GenresRepository
import ar.edu.uade.c012025.animeapp.domain.IGenresRepository
import kotlinx.coroutines.launch

class GenreViewModel(
    private val repository: IGenresRepository = GenresRepository()
) : ViewModel() {

    var genreList by mutableStateOf<List<GenreData>>(emptyList())
        private set

    init {
        loadGenres()
    }

    private fun loadGenres() {
        viewModelScope.launch {
            try {
                val animeGenres = repository.getAnimeGenres()
                val mangaGenres = repository.getMangaGenres()

                val allGenres = (animeGenres + mangaGenres)
                    .distinctBy { it.id }
                    .map { GenreData(it.id, it.name) }

                genreList = allGenres.sortedBy { it.name }
            } catch (e: Exception) {
                Log.e("GenreVM", "Error al cargar géneros", e)
            }
        }
    }
}