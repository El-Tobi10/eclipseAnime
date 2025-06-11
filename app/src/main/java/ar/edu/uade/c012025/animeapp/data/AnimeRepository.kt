package ar.edu.uade.c012025.animeapp.data

import android.content.Context
import ar.edu.uade.c012025.animeapp.data.localdata.AnimeEntity
import ar.edu.uade.c012025.animeapp.data.localdata.AppDatabase
import ar.edu.uade.c012025.animeapp.data.localdata.IAnimeDao
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository

class AnimeRepository(
    context: Context,
    val animeDataSource: IAnimeDataSource = AnimeApiDataSource(),
    private val animeDao: IAnimeDao = AppDatabase.createInstance(context).animeDao()
) : IAnimeRepository
{

    override suspend fun insertAnime(anime: AnimeEntity) {
        animeDao.insertAnime(anime)
    }

    override suspend fun getAnimeById(id: Int): AnimeEntity? {
        return animeDao.getAnimeById(id)
    }


    override suspend fun fetchAnimes(search: String) : List<Anime> {
        return animeDataSource.getAnimeList(search)
    }

    override suspend fun fetchAnime(animeId: Int): Anime {
        return animeDataSource.getAnimeById(animeId)
    }
    override suspend fun fetchCharacters(animeId: Int): List<Character> {
        return animeDataSource.getCharactersForAnime(animeId)
    }
    override suspend fun fetchRecommendations(animeId: Int): List<Anime> {
        return animeDataSource.getRecommendationsForAnime(animeId)
    }
    override suspend fun fetchRandomAnime(): Anime {
        return animeDataSource.getRandomAnime()
    }


}