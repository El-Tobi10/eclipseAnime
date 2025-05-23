package ar.edu.uade.c012025.animeapp.data

data class RecommendationResultManga(
    val data: List<RecommendationEntryWrapperManga>
)

data class RecommendationEntryWrapperManga(
    val entry: Manga
)
