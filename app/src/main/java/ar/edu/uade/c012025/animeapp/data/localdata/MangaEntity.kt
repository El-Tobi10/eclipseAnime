package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "manga_table")
data class MangaEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val titleJapanese: String?,
    val synopsis: String?,
    val background: String?,
    val chapters: Int?,
    val volumes: Int?,
    val status: String?,
    val publishing: Boolean,
    val score: Double?,
    val rank: Int?,
    val popularity: Int?,
    val imagesUrl: String,
    val genres: String,
    val authors: String,
    val serializations: String,
    val published: String
)