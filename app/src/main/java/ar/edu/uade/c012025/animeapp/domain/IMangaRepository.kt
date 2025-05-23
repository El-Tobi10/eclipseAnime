package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.Manga

interface IMangaRepository {
    suspend fun fetchMangas(search: String) : List<Manga>
    suspend fun fetchManga(mangaId: Int) : Manga
    suspend fun fetchCharacters(mangaId: Int) : List<CharacterData>
    suspend fun fetchRecommendations(mangaId: Int) : List<Manga>
}