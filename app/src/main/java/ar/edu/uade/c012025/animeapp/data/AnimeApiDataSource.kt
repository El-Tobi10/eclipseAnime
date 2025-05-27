package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import ar.edu.uade.c012025.animeapp.data.CharacterData
import okio.IOException
import retrofit2.HttpException

class AnimeApiDataSource : IAnimeDataSource {
    private val TAG = "EclipseApp"

    override suspend fun getAnimeList(search: String): List<Anime> {
        Log.d(TAG, "AnimeApiDataSource.getAnimeList")

        return try {
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Search: $search")
            val animeResult = RetrofitInstance.animeApi.getAnimeSearch(search)
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Result: ${animeResult.data.size}")
            return animeResult.data
        } catch (e: HttpException) {
            Log.e(TAG, "Error de HTTP: ${e.code()} ${e.message()}")
            emptyList()
        } catch (e: IOException) {
            Log.e(TAG, "Error de Network: ${e.localizedMessage}")
            emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error desconocido: ${e.localizedMessage}")
            emptyList()
        }
    }

    override suspend fun getAnimeById(animeId: Int): Anime {
        return RetrofitInstance.animeApi.getAnime(animeId).data
    }

    override suspend fun getCharactersForAnime(animeId: Int): List<Character> {
        return try {
            val result = RetrofitInstance.animeApi.getCharactersForAnime(animeId)
            result.data
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando personajes: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getRecommendationsForAnime(animeId: Int): List<Anime> {
        return try {
            val result = RetrofitInstance.animeApi.getRecommendationsForAnime(animeId)
            result.data.map { it.entry }
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando recomendaciones: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getRandomAnime(): Anime {
        return try{
            RetrofitInstance.animeApi.getRandomAnime().data
        } catch (e: HttpException) {
            Log.e(TAG, "Error de HTTP: ${e.code()} ${e.message()}")
            emptyAnime()
        }
    }

}