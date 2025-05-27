package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET

interface ITopAPI {
    @GET("top/anime?limit=8")
    suspend fun getTopAnime(): TopAnimeResult

    @GET("top/manga?limit=8")
    suspend fun getTopManga(): TopMangaResult

    @GET("watch/episodes")
    suspend fun getLastEpisodes(): EpisodeResult

}