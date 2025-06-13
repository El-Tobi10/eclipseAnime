package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import ar.edu.uade.c012025.animeapp.data.CharacterAnime
import ar.edu.uade.c012025.animeapp.data.CharacterManga

@Entity(tableName = "character_table")
data class CharacterEntity (
    @PrimaryKey val id: Int,
    val imagesUrl: String,
    val name: String,
    val nameKanji: String,
    val nicknames: String,
    val about: String,
    val anime: List<CharacterAnime>,
//    val animeRole: String?,
    val manga: List<CharacterManga>,
//    val mangaRole: String?
)