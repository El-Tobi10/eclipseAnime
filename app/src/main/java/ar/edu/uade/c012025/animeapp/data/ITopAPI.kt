package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ITopAPI {
    @GET("top/anime?limit=8")
    suspend fun getTopAnime(): TopAnimeResult

    @GET("top/manga?limit=8")
    suspend fun getTopManga(): TopMangaResult

    @GET("top/anime")
    suspend fun getAllTopAnime(@Query("page") page: Int): TopAnimeResult

    @GET("top/manga")
    suspend fun getAllTopManga(@Query("page") page: Int): TopMangaResult

    @GET("watch/episodes")
    suspend fun getLastEpisodes(): EpisodeResult

}