package ar.edu.uade.c012025.animeapp.data

import android.content.Context
import android.util.Log
import ar.edu.uade.c012025.animeapp.data.localdata.AnimeEntity
import ar.edu.uade.c012025.animeapp.data.localdata.AppDatabase
import ar.edu.uade.c012025.animeapp.data.localdata.CharacterEntity
import ar.edu.uade.c012025.animeapp.data.localdata.ICharactersDao
import ar.edu.uade.c012025.animeapp.domain.ICharacterRepository

class CharacterRepository (
    context: Context,
    val characterDao: ICharactersDao = AppDatabase.createInstance(context).characterDao(),
    val characterDataSource: ICharacterApiDataSource = CharacterApiDataSource()
) : ICharacterRepository {

    override suspend fun insertCharacter(character: CharacterEntity) {
        characterDao.insertCharacter(character)
    }

    override suspend fun getCharacterById(id: Int): CharacterEntity? {
        return characterDao.getCharacterById(id)
    }

    override suspend fun fetchCharacter(characterId: Int): CharacterData {
        Log.d("CharacterRepo", "Consultando character ID $characterId")
        return characterDataSource.getCharacterById(characterId)
    }

}