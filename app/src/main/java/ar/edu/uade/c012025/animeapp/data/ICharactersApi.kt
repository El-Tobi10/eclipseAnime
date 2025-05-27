package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ICharactersApi {

    @GET("characters/{characterId}/full")
    suspend fun getCharacter(
        @Path("characterId") characterId: Int
    ): CharacterDetailResult

    @GET("characters/{characterId}/anime")
    suspend fun getAnimeForCharacter(
        @Path("characterId") characterId: Int
    ): List<CharacterAnime>

    @GET("characters/{characterId}/manga")
    suspend fun getMangaForCharacter(
        @Path("characterId") characterId: Int
    ): List<CharacterManga>
}