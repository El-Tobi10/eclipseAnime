package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_table")
data class AnimeEntity(
    @PrimaryKey val id: Int,
    val imageUrl: String?,
    val title: String,
    val titleJapanese: String?,
    val type: String?,
    val trailerUrl: String?,
    val episodes: Int?,
    val status: String?,
    val score: Double?,
    val genres: String,
    val studios: String,
    val theme: String?,
    val synopsis: String?,
    val duration: String?,
    val rating: String?,
    val season: String?,
    val streaming: String,
    val year: Int?
)