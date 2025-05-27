package ar.edu.uade.c012025.animeapp.data

data class SearchItem(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val type: SearchItemType
)

enum class SearchItemType {
    ANIME, MANGA, EPISODE
}