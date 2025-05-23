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
fun MangaDetailScreen(
    mangaId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    vm: MangaDetailScreenViewModel = viewModel()
)
{
    vm.setMangaId(mangaId)

    if (vm.uiState.mangaDetail.id == 0) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else {
        MangaUiItemDetail(vm.uiState.mangaDetail, navController)
    }
}