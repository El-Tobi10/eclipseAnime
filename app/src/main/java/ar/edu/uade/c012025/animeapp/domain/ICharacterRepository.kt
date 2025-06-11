package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.localdata.AnimeEntity
import ar.edu.uade.c012025.animeapp.data.localdata.CharacterEntity

interface ICharacterRepository {
    suspend fun fetchCharacter(characterId: Int) : CharacterData
    suspend fun getCharacterById(id: Int): CharacterEntity?
    suspend fun insertCharacter(character: CharacterEntity)
}