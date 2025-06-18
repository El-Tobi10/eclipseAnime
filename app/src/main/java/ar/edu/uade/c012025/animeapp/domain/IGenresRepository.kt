package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.GenreData
import ar.edu.uade.c012025.animeapp.data.Manga

interface IGenresRepository {
    suspend fun getAnimeGenres(): List<GenreData>
    suspend fun getMangaGenres(): List<GenreData>
    suspend fun getAnimeByGenre(genreId : Int): List<Anime>
    suspend fun getMangaByGenre(genreId : Int): List<Manga>
}