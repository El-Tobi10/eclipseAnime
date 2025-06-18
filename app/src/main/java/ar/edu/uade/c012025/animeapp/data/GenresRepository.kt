package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.domain.IGenresRepository

class GenresRepository(
    val GenesDataSource: IGenreDataSource = GenreApiDataSource()
): IGenresRepository {
    override suspend fun getAnimeGenres(): List<GenreData> {
        return GenesDataSource.getAnimeGenres()
    }
    override suspend fun getMangaGenres(): List<GenreData>{
        return GenesDataSource.getMangaGenres()
    }
    override suspend fun getAnimeByGenre(genreId: Int): List<Anime> {
        return GenesDataSource.getAnimeByGenre(genreId)
    }
    override suspend fun getMangaByGenre(genreId: Int): List<Manga> {
        return GenesDataSource.getMangaByGenre(genreId)
    }

}