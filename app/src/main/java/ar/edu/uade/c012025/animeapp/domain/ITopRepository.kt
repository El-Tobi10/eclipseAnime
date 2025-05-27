package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.Episodes

interface ITopRepository {
    suspend fun fetchLastEpisodes(): List<Episodes>
    suspend fun fetchTopAnime(): List<Anime>
    suspend fun fetchTopManga(): List<Manga>
}