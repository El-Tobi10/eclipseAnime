package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class AnimeResult(
    val data: List<Anime>
)

data class AnimeCharacters(
    val data: List<Character>
)

data class AnimeDetailResult(
    val data: Anime
)

data class Anime(
    @SerializedName("mal_id") val id: Int,
    val images: Images?,
    val title: String,
    @SerializedName("title_japanese") val titleJapanese: String?,
    val type: String?,
    val trailer: Trailer?,
    val episodes: Int?,
    val status: String?,
    val score: Double?,
    val studios: List<Studios>,
    val synopsis: String?,
    val genres: List<Genre> = emptyList(),
    val themes: List<Genre> = emptyList(),
    val duration: String?,
    val rating: String?,
    val theme: Opening,
    val streaming: List<Streaming>,
    val season: String?,
    val year: Int?
)

data class Images(
    val jpg: ImagesJpg?
)

data class ImagesJpg(
    @SerializedName("image_url") val imageUrl: String
)

data class Studios(
    @SerializedName("mal_id") val id: Int,
    val name: String
)

data class Trailer(
    @SerializedName("youtube_id") val youtubeId: String,
    val url: String?,
    @SerializedName("embed_url") val embedUrl: String?
)
data class Opening(
    val openings: List<String>
)
data class Streaming(
    val name: String,
    val url: String
)
data class Genre(
    val name: String
)

fun emptyAnime(): Anime {
    return Anime(
        id = 0,
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
        streaming = emptyList(),
        theme = Opening(emptyList()),
        year = 0,
        trailer = Trailer("", "", ""),
        studios = emptyList()

    )
}
