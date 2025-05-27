package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.domain.ITopRepository

class TopRepositoy(val topDataSource: ITopDataSource = TopDataSource()) : ITopRepository {
    override suspend fun fetchLastEpisodes(): List<Episodes> {
        return topDataSource.getLastEpisodes()
    }

    override suspend fun fetchTopAnime(): List<Anime> {
        return topDataSource.getTopAnime()
    }
    override suspend fun fetchTopManga(): List<Manga> {
        return topDataSource.getTopManga()
    }

}