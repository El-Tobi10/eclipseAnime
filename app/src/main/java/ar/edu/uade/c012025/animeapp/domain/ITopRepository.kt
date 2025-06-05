package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.Episodes
import ar.edu.uade.c012025.animeapp.data.TopAnimeResult
import ar.edu.uade.c012025.animeapp.data.TopMangaResult

interface ITopRepository {
    suspend fun fetchLastEpisodes(): List<Episodes>
    suspend fun fetchTopAnime(): List<Anime>
    suspend fun fetchTopManga(): List<Manga>
    suspend fun fetchAllTopAnime(page: Int): TopAnimeResult
    suspend fun fetchAllTopManga(page: Int): TopMangaResult

}