package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IMangaDao {

    @Query("SELECT * FROM manga_table")
    suspend fun getAllManga(): List<MangaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManga(manga: MangaEntity)

    @Query("SELECT * FROM manga_table WHERE id = :id")
    suspend fun getMangaById(id: Int): MangaEntity?
}