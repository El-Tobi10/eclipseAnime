package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MangaApiDataSource : IMangaDataSource {
    private val TAG = "AnimeApp"

    override suspend fun getMangaList(search: String): List<Manga> {
        Log.d(TAG, "MangaApiDataSource.getMangaList")

        return try {
            Log.d(TAG, "MangaApiDataSource.getMangaList Search: $search")
            val mangaResult = RetrofitInstance.mangaApi.getMangaSearch(search)
            Log.d(TAG, "MangaApiDataSource.getMangaList Result: ${mangaResult.data.size}")
            return mangaResult.data
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

    override suspend fun getMangaById(mangaId: Int): Manga {
        return RetrofitInstance.mangaApi.getManga(mangaId).data
    }

}