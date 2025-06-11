package ar.edu.uade.c012025.animeapp.data

import android.content.Context
import ar.edu.uade.c012025.animeapp.data.localdata.AnimeEntity
import ar.edu.uade.c012025.animeapp.data.localdata.AppDatabase
import ar.edu.uade.c012025.animeapp.data.localdata.IAnimeDao
import ar.edu.uade.c012025.animeapp.data.localdata.IMangaDao
import ar.edu.uade.c012025.animeapp.data.localdata.MangaEntity
import ar.edu.uade.c012025.animeapp.domain.IMangaRepository

class MangaRepository (
    context: Context,
    val mangaDataSource: IMangaDataSource = MangaApiDataSource(),
    private val mangaDao: IMangaDao = AppDatabase.createInstance(context).mangaDao()
    ) : IMangaRepository
    {

        override suspend fun insertManga(manga: MangaEntity) {
            mangaDao.insertManga(manga)
        }

        override suspend fun getMangaById(id: Int): MangaEntity? {
            return mangaDao.getMangaById(id)
        }

        override suspend fun fetchMangas(search: String) : List<Manga> {
            return mangaDataSource.getMangaList(search)
        }

        override suspend fun fetchManga(mangaId: Int): Manga {
            return mangaDataSource.getMangaById(mangaId)
        }
        override suspend fun fetchCharacters(mangaId: Int): List<Character> {
            return mangaDataSource.getCharactersForManga(mangaId)
        }
        override suspend fun fetchRecommendations(mangaId: Int): List<Manga> {
            return mangaDataSource.getRecommendationsForManga(mangaId)
        }
        override suspend fun fetchRandomManga(): Manga {
            return mangaDataSource.getRandomManga()
        }
}