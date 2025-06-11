package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ICharactersDao {

    @Query("SELECT * FROM character_table")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM character_table WHERE id = :id")
    suspend fun getCharacterById(id: Int): CharacterEntity?

}