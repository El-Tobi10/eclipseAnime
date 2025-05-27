package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class EpisodeResult(
    val data: List<Episodes>
)

data class Episodes(
    val entry: EpisodeEntry,
    val episodes: List<Episode>
)

data class EpisodeEntry(
    @SerializedName("mal_id") val id: Int,
    val title: String,
    val images: Images,
)

data class Episode(
    @SerializedName("mal_id") val id: Int,
    val title: String
)