package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import kotlinx.coroutines.delay

class TopDataSource : ITopDataSource {
    private val TAG = "EclipseApp"

    override suspend fun getLastEpisodes(): List<Episodes> {
        return try {
            val result = RetrofitInstance.topApi.getLastEpisodes()
            result.data
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando ultimos episodios: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getTopAnime(): List<Anime> {
        return try {
            val result = RetrofitInstance.topApi.getTopAnime()
            result.data
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando animes populares: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getTopManga(): List<Manga> {
        return try {
            val result = RetrofitInstance.topApi.getTopManga()
            result.data
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando mangas populares: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getAllTopAnime(page: Int): TopAnimeResult {
        return try {
            val result = RetrofitInstance.topApi.getAllTopAnime(page)
            result
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando animes populares: ${e.message}")
        } as TopAnimeResult
    }

    override suspend fun getAllTopManga(page: Int): TopMangaResult {
        return try {
            val result = RetrofitInstance.topApi.getAllTopManga(page)
            result
        } catch (e: Exception) {
            Log.e(TAG, "Error cargando mangas populares: ${e.message}")
        } as TopMangaResult
    }

}