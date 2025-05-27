package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.CharacterData

interface ICharacterRepository {
    suspend fun fetchCharacter(characterId: Int) : CharacterData
}