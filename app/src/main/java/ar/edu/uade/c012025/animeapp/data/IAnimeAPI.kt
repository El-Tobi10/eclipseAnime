package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IAnimeAPI {
    @GET("anime")
    suspend fun getAnimeSearch(
        @Query("q") search: String
    ) : AnimeResult

    @GET("anime/{animeId}")
    suspend fun getAnime(
        @Path("animeId") animeId: Int
    ): AnimeDetailResult
}