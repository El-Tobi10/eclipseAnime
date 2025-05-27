package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import ar.edu.uade.c012025.animeapp.domain.ICharacterRepository

class CharacterRepository (val characterDataSource: ICharacterApiDataSource = CharacterApiDataSource()) : ICharacterRepository {
    override suspend fun fetchCharacter(characterId: Int): CharacterData {
        Log.d("CharacterRepo", "Consultando character ID $characterId")
        return characterDataSource.getCharacterById(characterId)

    }

}