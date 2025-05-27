package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IAnimeAPI {
    @GET("anime")
    suspend fun getAnimeSearch(
        @Query("q") search: String
    ) : AnimeResult

    @GET("anime/{animeId}/full")
    suspend fun getAnime(
        @Path("animeId") animeId: Int
    ): AnimeDetailResult

    @GET("anime/{animeId}/characters")
    suspend fun getCharactersForAnime(
        @Path("animeId") animeId: Int
    ): AnimeCharacters

    @GET("anime/{animeId}/recommendations")
    suspend fun getRecommendationsForAnime(
        @Path("animeId") animeId: Int
    ): RecommendationResultAnime

    @GET("random/anime")
    suspend fun getRandomAnime(): AnimeDetailResult
}