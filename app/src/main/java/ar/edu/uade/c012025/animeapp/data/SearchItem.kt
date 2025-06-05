package ar.edu.uade.c012025.animeapp.data

import com.google.firebase.firestore.PropertyName

data class SearchItem(
    @get:PropertyName("id")
    val id: Int = 0,

    @get:PropertyName("title")
    val title: String = "",

    @get:PropertyName("imageUrl")
    val imageUrl: String? = null,

    @get:PropertyName("type")
    val type: SearchItemType = SearchItemType.ANIME
) {
    constructor() : this(0, "", null, SearchItemType.ANIME)
}

enum class SearchItemType {
    ANIME, MANGA, EPISODE
}