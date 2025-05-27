package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    val data: List<CharacterData>
)

data class CharacterDetailResult(
    val data: CharacterData
)

data class CharacterData(
    @SerializedName("mal_id") val id: Int,
    val images: Images?,
    val name: String?,
    @SerializedName("name_kanji") val nameKanji: String?,
    val nicknames: List<String>?,
    val about: String?,
    val anime: List<CharacterAnime>,
    val manga: List<CharacterManga>
)

data class CharacterAnime(
    val role: String?,
    val anime: AnimeStats?
)

data class AnimeStats(
    @SerializedName("mal_id") val id: Int,
    val title: String?,
    val Images: Images?
)

data class CharacterManga(
    val role: String?,
    val manga: MangaStats?
)

data class MangaStats(
    @SerializedName("mal_id") val id: Int,
    val title: String?,
    val Images: Images?
)

fun emptyCharacter(): CharacterData{
    return CharacterData(
        id = 0,
        images = null,
        name = "",
        nameKanji = "",
        nicknames = emptyList(),
        about = "",
        anime = emptyList(),
        manga = emptyList()
    )
}