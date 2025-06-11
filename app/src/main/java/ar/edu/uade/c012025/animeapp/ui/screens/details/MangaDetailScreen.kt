package ar.edu.uade.c012025.animeapp.ui.screens.details

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
import ar.edu.uade.c012025.animeapp.data.FavoritesRepository
import ar.edu.uade.c012025.animeapp.data.MangaRepository

@Composable
fun MangaDetailScreen(
    mangaId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    //vm: MangaDetailScreenViewModel = viewModel()
)
{
    val context = LocalContext.current.applicationContext
    val mangaRepository = MangaRepository(context)
    val favoritesRepository = FavoritesRepository()

    val vm: MangaDetailScreenViewModel = viewModel(
        factory = MangaDetailViewModelFactory(mangaRepository, favoritesRepository)
    )
    vm.setMangaId(mangaId)

    if (vm.uiState.mangaDetail.id == 0) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else {
        LaunchedEffect(mangaId) {
            vm.loadManga(mangaId)
        }

        val manga = vm.manga
        if (manga != null) {
            MangaUiItemDetail(manga, navController, vm)
        } else {
            CircularProgressIndicator()
        }
    }
}