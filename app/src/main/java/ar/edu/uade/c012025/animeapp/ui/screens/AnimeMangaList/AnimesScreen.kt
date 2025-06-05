package ar.edu.uade.c012025.animeapp.ui.screens.AnimeMangaList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SectionTitle
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import coil.compose.AsyncImage

@Composable
fun AnimesScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(),
    vm: AnimeMangaListViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()
    val items = vm.items

    LaunchedEffect(Unit) {
        vm.loadContent(SearchItemType.ANIME)
    }
//    val listState = rememberLazyGridState()
//
//    LaunchedEffect(Unit) {
//        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
//            .collect { index ->
//                if (index != null) {
//                    vm.loadContent(SearchItemType.ANIME)
//                }
//            }
//    }

    AppScaffold(
        navController = navController,
        user = user,
        authViewModel = authViewModel
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 15.dp)
        ) {
            SectionTitle("Animes")
            Spacer(modifier = Modifier.height(12.dp))
            ItemGrid(items = items, navController = navController)
        }
    }
}
