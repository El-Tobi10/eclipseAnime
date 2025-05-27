package ar.edu.uade.c012025.animeapp.data

interface IMangaDataSource {
    suspend fun getMangaList(search: String) : List<Manga>
    suspend fun getMangaById(mangaId: Int) : Manga
    suspend fun getCharactersForManga(mangaId: Int): List<Character>
    suspend fun getRecommendationsForManga(mangaId: Int): List<Manga>
    suspend fun getRandomManga(): Manga
}