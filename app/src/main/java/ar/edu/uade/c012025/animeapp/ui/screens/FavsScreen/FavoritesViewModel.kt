package ar.edu.uade.c012025.animeapp.ui.screens.FavsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.data.SearchItem
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val repository: FavoritesRepository = FavoritesRepository()
) : ViewModel() {

    var favorites by mutableStateOf<List<SearchItem>>(emptyList())
        private set

    fun loadFavorites(email: String) {
        viewModelScope.launch {
            try {
                val favs = repository.getFavorites(email)
                favorites = favs
            } catch (e: Exception) {
                // Loguear error si querés
                favorites = emptyList()
            }
        }
    }
}
