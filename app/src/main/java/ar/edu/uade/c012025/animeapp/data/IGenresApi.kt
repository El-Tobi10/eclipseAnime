package ar.edu.uade.c012025.animeapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface IGenresApi {
    @GET("genres/anime")
    suspend fun getAnimeGenres(): GenreListResult

    @GET("genres/manga")
    suspend fun getMangaGenres(): GenreListResult

    @GET("anime")
    suspend fun getAnimeByGenre(@Query("genres") genreId: Int): AnimeGenreListResult

    @GET("manga")
    suspend fun getMangaByGenre(@Query("genres") genreId: Int): MangaGenreListResult

}