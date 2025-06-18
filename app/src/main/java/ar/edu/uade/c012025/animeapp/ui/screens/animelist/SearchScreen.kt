package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.ui.screens.GenreSearch.GenreSearch
import ar.edu.uade.c012025.animeapp.ui.screens.GenreSearch.GenreViewModel
import ar.edu.uade.c012025.animeapp.ui.screens.Screens
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.Header
import ar.edu.uade.c012025.animeapp.ui.screens.commons.HeaderIndex
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SearchUIList
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun AnimeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(),
    genre: GenreViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()
    val context = LocalContext.current
    val vm: SearchViewModel = viewModel(factory = SearchViewModelFactory(context))
    var selectedGenreId by remember { mutableStateOf<Int?>(null) }

    AppScaffold(
        navController = navController,
        user = user,
        authViewModel = authViewModel
    ) {padding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 15.dp)
        ) {

            Text(
                text = "Resultados",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = vm.uiState.searchQuery,
                    modifier = Modifier.weight(1f),
                    label = { Text("Buscar anime o manga:") },
                    singleLine = true,
                    onValueChange = { vm.searchChange(it) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { vm.fetchResults() }
                ) {
                    Text("Buscar")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))


            GenreSearch(
                genres = genre.genreList,
                selectedGenreId = selectedGenreId,
                onClick = { genre ->
                    selectedGenreId = genre.id
                    vm.fetchByGenre(genre.id)
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            SearchUIList(vm.uiState.searchResults, Modifier.fillMaxSize()) { item ->
                when (item.type) {
                    SearchItemType.ANIME -> navController.navigate(Screens.AnimeDetail.route + "/${item.id}")
                    SearchItemType.MANGA -> navController.navigate(Screens.MangaDetail.route + "/${item.id}")

                    else -> throw IllegalStateException("Unexpected item type: ${item.type}")
                }
            }
        }
    }
}

