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

    @GET("anime/{id}/characters")
    suspend fun getCharactersForAnime(@Path("id") animeId: Int): CharacterResult

    @GET("anime/{id}/recommendations")
    suspend fun getRecommendationsForAnime(@Path("id") animeId: Int): RecommendationResultAnime
}