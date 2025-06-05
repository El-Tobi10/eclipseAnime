package ar.edu.uade.c012025.animeapp.ui.screens.AnimeMangaList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.data.TopMangaResult
import ar.edu.uade.c012025.animeapp.data.TopRepositoy
import ar.edu.uade.c012025.animeapp.domain.ITopRepository
import kotlinx.coroutines.launch

class AnimeMangaListViewModel(
    private val topRepository: ITopRepository = TopRepositoy()
) : ViewModel() {

    var items by mutableStateOf<List<SearchItem>>(emptyList())
        private set

    private var currentPage = 1
    private var isLoading = false
//    fun loadAnimes() {
//        viewModelScope.launch {
//            items = topRepository.fetchAllTopAnime().map {
//                SearchItem(
//                    id = it.id,
//                    title = it.title,
//                    imageUrl = it.images?.jpg?.imageUrl,
//                    type = SearchItemType.ANIME
//                )
//            }
//        }
//    }
//
//    fun loadMangas() {
//        viewModelScope.launch {
//            items = topRepository.fetchAllTopManga().map {
//                SearchItem(
//                    id = it.id,
//                    title = it.title,
//                    imageUrl = it.images.jpg?.imageUrl,
//                    type = SearchItemType.MANGA
//                )
//            }
//        }
//    }
    fun loadContent(type: SearchItemType, page: Int = currentPage) {
        if (isLoading) return
        isLoading = true
        viewModelScope.launch {
            val newItems = when (type) {
                SearchItemType.ANIME -> {
                    topRepository.fetchAllTopAnime(page).data.map {
                        SearchItem(it.id, it.title, it.images?.jpg?.imageUrl, SearchItemType.ANIME)
                    }
                }
                SearchItemType.MANGA -> {
                    topRepository.fetchAllTopManga(page).data.map {
                        SearchItem(it.id, it.title, it.images?.jpg?.imageUrl, SearchItemType.MANGA)
                    }
                }
                else -> emptyList()
            }
            items = items + newItems
        }
    }

    fun reset(type: SearchItemType) {
        items = emptyList()
        currentPage = 1
        loadContent(type)
    }
}
