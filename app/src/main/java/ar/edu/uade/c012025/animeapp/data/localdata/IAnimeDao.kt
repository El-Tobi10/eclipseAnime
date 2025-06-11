package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IAnimeDao {

    @Query("SELECT * FROM anime_table")
    suspend fun getAllAnimes(): List<AnimeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(anime: AnimeEntity)

    @Query("SELECT * FROM anime_table WHERE id = :id")
    suspend fun getAnimeById(id: Int): AnimeEntity?
}