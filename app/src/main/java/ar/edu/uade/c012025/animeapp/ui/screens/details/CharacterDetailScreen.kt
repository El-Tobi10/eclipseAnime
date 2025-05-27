package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    vm: CharacterDetailScreenViewModel = viewModel()
)
{

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
        CharacterUiItemDetail(vm.uiState.characterDetail, navController)
    }
}