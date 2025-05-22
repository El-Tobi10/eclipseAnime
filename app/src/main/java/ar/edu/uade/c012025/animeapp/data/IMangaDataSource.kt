package ar.edu.uade.c012025.animeapp.data

interface IMangaDataSource {
    suspend fun getMangaList(search: String) : List<Manga>
    suspend fun getMangaById(animeId: Int) : Manga
}