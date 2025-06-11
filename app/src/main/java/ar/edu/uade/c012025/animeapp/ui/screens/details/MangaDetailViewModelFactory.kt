package ar.edu.uade.c012025.animeapp.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository

class MangaDetailViewModelFactory(
    private val mangaRepository: IMangaRepository,
    private val favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MangaDetailScreenViewModel(mangaRepository, favoritesRepository) as T
    }
}