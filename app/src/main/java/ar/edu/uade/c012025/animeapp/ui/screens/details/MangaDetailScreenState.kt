package ar.edu.uade.c012025.animeapp.ui.screens.details

import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.emptyManga


data class MangaDetailScreenState (val mangaId: Int = 0, val mangaDetail: Manga = emptyManga())