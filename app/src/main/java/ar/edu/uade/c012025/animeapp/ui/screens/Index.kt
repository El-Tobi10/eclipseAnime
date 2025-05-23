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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.commons.HeaderIndex
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.ItemRow
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RandomButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.SectionTitle

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderIndex()
        // Botones Random
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RandomButton(text = "Random Anime", color = MaterialTheme.colorScheme.primary, navController)
            RandomButton(text = "Random Manga", color = MaterialTheme.colorScheme.primary, navController)
        }

        SectionTitle("Últimos Episodios")
        //ItemRow(items = getLastEpisodes())

        SectionTitle("Animes Populares")
        //ItemGrid(items = getPopularAnimes())

        SectionTitle("Mangas Populares")
        //ItemGrid(items = getPopularMangas())
    }
}
