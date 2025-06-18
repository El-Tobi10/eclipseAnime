package ar.edu.uade.c012025.animeapp.data

interface IGenreDataSource {
    suspend fun getAnimeGenres(): List<GenreData>
    suspend fun getMangaGenres(): List<GenreData>
    suspend fun getAnimeByGenre(genreId: Int): List<Anime>
    suspend fun getMangaByGenre(genreId: Int): List<Manga>

}