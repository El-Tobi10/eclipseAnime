package ar.edu.uade.c012025.animeapp.data

data class SearchScreenState (
    val searchQuery: String = "",
    val searchResults: List<SearchItem> = emptyList()
)