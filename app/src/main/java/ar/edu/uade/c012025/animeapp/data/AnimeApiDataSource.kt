package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeApiDataSource : IAnimeDataSource {
    private val TAG = "AnimeApp"

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

}