package ar.edu.uade.c012025.animeapp.data

interface ITopDataSource {
    suspend fun getLastEpisodes(): List<Episodes>
    suspend fun getTopAnime(): List<Anime>
    suspend fun getTopManga(): List<Manga>
    suspend fun getAllTopAnime(page: Int): TopAnimeResult
    suspend fun getAllTopManga(page: Int): TopMangaResult

}