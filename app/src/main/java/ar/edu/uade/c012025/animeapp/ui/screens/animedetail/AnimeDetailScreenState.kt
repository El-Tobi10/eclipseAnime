package ar.edu.uade.c012025.animeapp.ui.screens.animedetail

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.emptyAnime

data class AnimeDetailScreenState(val animeId: Int = 0, val animeDetail: Anime = emptyAnime())