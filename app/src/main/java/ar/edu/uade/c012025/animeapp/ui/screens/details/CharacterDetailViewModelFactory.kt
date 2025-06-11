package ar.edu.uade.c012025.animeapp.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import ar.edu.uade.c012025.animeapp.domain.ICharacterRepository

class CharacterDetailViewModelFactory(
    private val characterRepository: ICharacterRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterDetailScreenViewModel(characterRepository) as T
    }
}