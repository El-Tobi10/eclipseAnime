package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class CharacterEntity (
    @PrimaryKey val id: Int,
    val imagesUrl: String,
    val name: String,
    val nameKanji: String,
    val nicknames: String,
    val about: String,
    val anime: String?,
//    val animeRole: String?,
    val manga: String?,
//    val mangaRole: String?
)