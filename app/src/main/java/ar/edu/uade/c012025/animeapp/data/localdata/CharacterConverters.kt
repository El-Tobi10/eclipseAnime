package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ar.edu.uade.c012025.animeapp.data.CharacterAnime
import ar.edu.uade.c012025.animeapp.data.CharacterManga

class CharacterConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromCharacterAnimeList(value: List<CharacterAnime>?): String =
        gson.toJson(value)

    @TypeConverter
    fun toCharacterAnimeList(value: String): List<CharacterAnime> {
        val type = object : TypeToken<List<CharacterAnime>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromCharacterMangaList(value: List<CharacterManga>?): String =
        gson.toJson(value)

    @TypeConverter
    fun toCharacterMangaList(value: String): List<CharacterManga> {
        val type = object : TypeToken<List<CharacterManga>>() {}.type
        return gson.fromJson(value, type)
    }
}
