package ar.edu.uade.c012025.animeapp.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun AnimeDetailScreen(
    animeId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    vm: AnimeDetailScreenViewModel = viewModel()
)
{
    vm.setAnimeId(animeId)

    if (vm.uiState.animeDetail.id == 0) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else {
        AnimeUiItemDetail(vm.uiState.animeDetail, navController)
    }
}