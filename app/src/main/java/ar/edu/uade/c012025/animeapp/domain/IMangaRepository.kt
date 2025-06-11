package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Character
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.localdata.MangaEntity

interface IMangaRepository {
    suspend fun fetchMangas(search: String) : List<Manga>
    suspend fun fetchManga(mangaId: Int) : Manga
    suspend fun fetchCharacters(mangaId: Int) : List<Character>
    suspend fun fetchRecommendations(mangaId: Int) : List<Manga>
    suspend fun fetchRandomManga() : Manga
    suspend fun getMangaById(id: Int): MangaEntity?
    suspend fun insertManga(manga: MangaEntity)
}