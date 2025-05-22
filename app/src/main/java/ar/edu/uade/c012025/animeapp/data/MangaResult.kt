package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class MangaResult(
    val data: List<Manga>
)

data class MangaDetailResult(
    val data: Manga
)

data class Manga(
    @SerializedName("mal_id")
    val id: Int,
    val title: String,
    @SerializedName("title_japanese")
    val titleJapanese: String?,
    val synopsis: String,
    val background: String?,
    val chapters: Int?,
    val volumes: Int?,
    val status: String,
    val publishing: Boolean,
    val score: Double?,
    val rank: Int?,
    val popularity: Int?,
    val images: Images,
    val genres: List<Genres>,
    val themes: List<Genres>,
    val demographics: List<Genres>,
    val authors: List<Author>,
    val serializations: List<Serialization>,
    val published: Published
)

data class Author(
    @SerializedName("mal_id")
    val id: Int,
    val name: String,
    val url: String
)

data class Serialization(
    @SerializedName("mal_id")
    val id: Int,
    val name: String,
    val url: String
)

data class Published(
    val string: String
)

data class Genres(
    @SerializedName("mal_id")
    val id: Int,
    val name: String,
    val url: String
)

fun emptyManga(): Manga {
    return Manga(
        id = 0,
        title = "",
        titleJapanese = "",
        synopsis = "",
        background = "",
        chapters = null,
        volumes = null,
        status = "",
        publishing = false,
        score = null,
        rank = null,
        popularity = null,
        images = Images(ImagesJpg("")),
        genres = emptyList(),
        themes = emptyList(),
        demographics = emptyList(),
        authors = emptyList(),
        serializations = emptyList(),
        published = Published( "")
    )
}
