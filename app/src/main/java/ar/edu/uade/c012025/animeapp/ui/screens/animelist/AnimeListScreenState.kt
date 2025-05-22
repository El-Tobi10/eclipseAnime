package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import ar.edu.uade.c012025.animeapp.data.Anime

data class AnimeListScreenState(
    val animeList: List<Anime> = emptyList(),
    val searchQuery: String = ""
)