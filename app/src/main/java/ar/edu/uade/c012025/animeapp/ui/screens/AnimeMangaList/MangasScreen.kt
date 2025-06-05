package ar.edu.uade.c012025.animeapp.ui.screens.AnimeMangaList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SectionTitle
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel


@Composable
fun MangasScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(),
    vm: AnimeMangaListViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()
    val items = vm.items

    LaunchedEffect(Unit) {
        vm.loadContent(SearchItemType.MANGA)
    }

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
            SectionTitle("Mangas")
            Spacer(modifier = Modifier.height(12.dp))
            ItemGrid(items = items, navController = navController)
        }
    }
}
