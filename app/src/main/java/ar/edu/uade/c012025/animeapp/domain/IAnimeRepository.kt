package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.CharacterData

interface IAnimeRepository {
    suspend fun fetchAnimes(search: String) : List<Anime>
    suspend fun fetchAnime(animeId: Int) : Anime
    suspend fun fetchCharacters(animeId: Int) : List<CharacterData>
    suspend fun fetchRecommendations(animeId: Int) : List<Anime>

}