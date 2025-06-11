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
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel

@Composable
fun AnimeDetailScreen(
    animeId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    //vm: AnimeDetailScreenViewModel = viewModel()
)
{
    val context = LocalContext.current.applicationContext
    val animeRepository = AnimeRepository(context)
    val favoritesRepository = FavoritesRepository()

    val vm: AnimeDetailScreenViewModel = viewModel(
        factory = AnimeDetailViewModelFactory(animeRepository, favoritesRepository)
    )

    vm.setAnimeId(animeId)

    if (vm.uiState.animeDetail.id == 0) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    else {
        LaunchedEffect(animeId) {
            vm.loadAnime(animeId)
        }

        val anime = vm.anime
        if (anime != null) {
            AnimeUiItemDetail(anime = anime, navController = navController, vm = vm)
        } else {
            CircularProgressIndicator()
        }
        //AnimeUiItemDetail(vm.uiState.animeDetail, navController)
    }
}