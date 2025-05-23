package ar.edu.uade.c012025.animeapp.data

data class RecommendationResultAnime(
    val data: List<RecommendationEntryWrapper>
)

data class RecommendationEntryWrapper(
    val entry: Anime
)
