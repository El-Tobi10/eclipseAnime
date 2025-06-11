package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.data.CharacterRepository
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    //vm: CharacterDetailScreenViewModel = viewModel()
)
{
    val context = LocalContext.current.applicationContext
    val characterRepository = CharacterRepository(context)

    val vm: CharacterDetailScreenViewModel = viewModel(
        factory = CharacterDetailViewModelFactory(characterRepository)
    )

    vm.setCharacterId(characterId)

    val character = vm.uiState.characterDetail.name

    if (vm.uiState.characterDetail.id == 0) {
        Log.d("CharacterDetailScreen", "Cargando personaje ID $character")
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Log.d("CharacterDetailScreen", "Cargando personaje ID $characterId")
            CircularProgressIndicator()
        }
    }
    else {
        LaunchedEffect(characterId) {
            vm.loadCharacter(characterId)
        }

        val character = vm.character
        if (character != null) {
            CharacterUiItemDetail(character, navController)
        } else {
            CircularProgressIndicator()
        }
    }
}