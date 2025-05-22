package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class AnimeResult(
    val data: List<Anime>
)

data class AnimeDetailResult(
    val data: Anime
)

data class Anime(
    @SerializedName("mal_id") val id: Int,
    val url: String,
    val images: Images,
    val title: String,
    @SerializedName("title_japanese") val titleJapanese: String?,
    val type: String?,
    val episodes: Int?,
    val status: String?,
    val score: Double?,
    val synopsis: String,
    val genres: List<Genre> = emptyList(),
    val themes: List<Genre> = emptyList(),
    val duration: String?,
    val rating: String?,
    val season: String?,
    val year: Int?
)

data class Images(
    val jpg: ImagesJpg
)

data class ImagesJpg(
    @SerializedName("image_url") val imageUrl: String
)

data class Genre(
    val name: String
)

fun emptyAnime(): Anime {
    return Anime(
        id = 0,
        url = "",
        images = Images(ImagesJpg("")),
        title = "",
        titleJapanese = "",
        type = "",
        episodes = 0,
        status = "",
        score = 0.0,
        synopsis = "",
        genres = emptyList(),
        themes = emptyList(),
        duration = "",
        rating = "",
        season = "",
        year = 0
    )
}
