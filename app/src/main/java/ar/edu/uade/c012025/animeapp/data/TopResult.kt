package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.ui.screens.pagination.PaginatedResponse
import com.google.gson.annotations.SerializedName

data class TopAnimeResult(
    override val pagination: Pagination,
    override val data: List<Anime>
) : PaginatedResponse<Anime>

data class TopMangaResult(
    override val pagination: Pagination,
    override val data: List<Manga>
) : PaginatedResponse<Manga>

data class Pagination(
    @SerializedName("last_visible_page") val lastVisiblePage: Int,
    @SerializedName("has_next_page") val hasNextPage: Boolean,
    @SerializedName("current_page") val currentPage: Int
)