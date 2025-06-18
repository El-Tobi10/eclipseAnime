package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class GenreListResult(
    val data: List<GenreData>
)

data class GenreData(
    @SerializedName("mal_id")
    val id: Int,
    val name: String
)

data class AnimeGenreListResult(
    val data: List<Anime>
)

data class MangaGenreListResult(
    val data: List<Manga>
)