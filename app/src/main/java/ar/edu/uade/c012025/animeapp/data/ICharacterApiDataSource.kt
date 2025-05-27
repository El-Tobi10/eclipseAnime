package ar.edu.uade.c012025.animeapp.data

interface ICharacterApiDataSource {
    suspend fun getCharacterById(characterId: Int) : CharacterData
}