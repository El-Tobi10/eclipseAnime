package ar.edu.uade.c012025.animeapp.ui.screens.FavsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SectionTitle
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel

@Composable
fun FavsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(),
    vm: FavoritesViewModel = viewModel()
){
    val user by authViewModel.user.collectAsState()
    val email = user?.email ?: ""

    LaunchedEffect(email) {
        if (email.isNotBlank()) {
            vm.loadFavorites(email)
        }
    }
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
            SectionTitle("Mis Favoritos")

            Spacer(modifier = Modifier.height(12.dp))

            if (vm.favorites.isEmpty()) {
                Text("Todavía no agregaste favoritos.")
            } else {
                ItemGrid(items = vm.favorites, navController = navController, modifier = Modifier
                    .fillMaxHeight()
                )
            }
        }
    }
}