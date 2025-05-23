package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.domain.IMangaRepository

class MangaRepository (
    val mangaDataSource: IMangaDataSource = MangaApiDataSource()
    ) : IMangaRepository
    {
        override suspend fun fetchMangas(search: String) : List<Manga> {
            return mangaDataSource.getMangaList(search)
        }

        override suspend fun fetchManga(mangaId: Int): Manga {
            return mangaDataSource.getMangaById(mangaId)
        }
        override suspend fun fetchCharacters(mangaId: Int): List<CharacterData> {
            return mangaDataSource.getCharactersForManga(mangaId)
        }
        override suspend fun fetchRecommendations(mangaId: Int): List<Manga> {
            return mangaDataSource.getRecommendationsForManga(mangaId)
        }
}