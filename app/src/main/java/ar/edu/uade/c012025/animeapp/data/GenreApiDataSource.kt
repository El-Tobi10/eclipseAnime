package ar.edu.uade.c012025.animeapp.data

class GenreApiDataSource : IGenreDataSource {

    override suspend fun getAnimeGenres(): List<GenreData> {
        return RetrofitInstance.genresApi.getAnimeGenres().data
    }

    override suspend fun getMangaGenres(): List<GenreData> {
        return RetrofitInstance.genresApi.getMangaGenres().data
    }
    override suspend fun getAnimeByGenre(genreId: Int): List<Anime> {
        return RetrofitInstance.genresApi.getAnimeByGenre(genreId).data
    }
    override suspend fun getMangaByGenre(genreId: Int): List<Manga> {
        return RetrofitInstance.genresApi.getMangaByGenre(genreId).data

    }
}