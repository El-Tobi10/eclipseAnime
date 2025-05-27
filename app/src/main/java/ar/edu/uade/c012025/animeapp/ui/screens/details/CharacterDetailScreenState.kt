package ar.edu.uade.c012025.animeapp.ui.screens.details

import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.emptyCharacter

data class CharacterDetailScreenState (val characterId : Int = 0, val characterDetail: CharacterData = emptyCharacter())