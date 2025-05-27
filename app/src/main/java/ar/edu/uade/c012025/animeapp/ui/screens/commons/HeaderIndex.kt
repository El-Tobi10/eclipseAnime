package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.Screens

import coil.compose.AsyncImage

@Composable
fun HeaderIndex(navController : NavHostController, onMenuClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onMenuClick ) {
            Icon(Icons.Default.Menu,
                contentDescription = "Menú",
                modifier = Modifier.size(30.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        AsyncImage(
            model = "https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//logo_completo_invertido.png", // o tu logo
            contentDescription = "Logo Eclipse",
            modifier = Modifier
                .size(130.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { navController.navigate(Screens.AnimeList.route) }) {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
        }

    }
}