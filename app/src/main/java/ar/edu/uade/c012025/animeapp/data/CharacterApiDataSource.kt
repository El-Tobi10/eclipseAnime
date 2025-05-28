package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import kotlinx.coroutines.delay

class CharacterApiDataSource : ICharacterApiDataSource {
    override suspend fun getCharacterById(characterId: Int): CharacterData {
        val response = RetrofitInstance.charactersApi.getCharacter(characterId)
        Log.d("CharacterRepo", "Respuesta HTTP OK: ${response.data.name}")
        if (response.data == null) {
            throw Exception("Character no encontrado para ID $characterId")
        }
        return response.data

    }
}