package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Character
import ar.edu.uade.c012025.animeapp.data.localdata.AnimeEntity

interface IAnimeRepository {
    suspend fun fetchAnimes(search: String) : List<Anime>
    suspend fun fetchAnime(animeId: Int) : Anime
    suspend fun fetchCharacters(animeId: Int) : List<Character>
    suspend fun fetchRecommendations(animeId: Int) : List<Anime>
    suspend fun fetchRandomAnime() : Anime
    suspend fun getAnimeById(id: Int): AnimeEntity?
    suspend fun insertAnime(anime: AnimeEntity)

}