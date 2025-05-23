package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    val data: List<CharacterEntry>
)
data class CharacterEntry(
    val character: CharacterData
)
data class CharacterData(
    @SerializedName("mal_id") val id: Int,
    val name: String,
    val images: Images,
    @SerializedName("name_kanji") val nameKanji: String?,
    val about: String
)