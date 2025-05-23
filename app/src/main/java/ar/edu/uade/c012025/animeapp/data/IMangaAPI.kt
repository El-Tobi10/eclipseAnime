package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMangaAPI {
    @GET("manga")
    suspend fun getMangaSearch(
        @Query("q") search: String
    ) : MangaResult

    @GET("manga/{mangaId}")
    suspend fun getManga(
        @Path("mangaId") mangaId: Int
    ): MangaDetailResult

    @GET("manga/{id}/characters")
    suspend fun getCharactersForManga(@Path("id") mangaId: Int): CharacterResult

    @GET("manga/{id}/recommendations")
    suspend fun getRecommendationsForManga(@Path("id") mangaId: Int): RecommendationResultManga
}