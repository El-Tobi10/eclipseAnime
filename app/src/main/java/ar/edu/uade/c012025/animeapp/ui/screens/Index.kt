package ar.edu.uade.c012025.animeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.commons.DrawerContent
import ar.edu.uade.c012025.animeapp.ui.screens.commons.HeaderIndex
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemRow
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RandomButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SectionTitle
import ar.edu.uade.c012025.animeapp.ui.screens.index.HomeViewModel
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue


@Composable
fun HomeScreen(
    navController: NavHostController,
    vm: HomeViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                user = user,
                onNavigate = { route ->
                    navController.navigate(route)
                    scope.launch { drawerState.close() }
                },
                onLogout = {
                    authViewModel.logOut()
                    navController.navigate("login_screen") {
                        popUpTo(0)
                    }
                }
            )
        }
    ) {
        val state = vm.uiState

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            HeaderIndex(navController = navController, onMenuClick = { scope.launch { drawerState.open() } })

            // Botones Random
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RandomButton(text = "Random Anime", color = MaterialTheme.colorScheme.primary, navController)
                RandomButton(text = "Random Manga", color = MaterialTheme.colorScheme.primary, navController)
            }

            SectionTitle("Últimos Episodios")
            ItemRow(items = state.lastEpisodes, navController = navController)

            SectionTitle("Animes Populares")
            ItemGrid(items = state.topAnimes, navController = navController)

            SectionTitle("Mangas Populares")
            ItemGrid(items = state.topMangas, navController = navController)
        }
    }
}

