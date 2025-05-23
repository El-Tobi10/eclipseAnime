package ar.edu.uade.c012025.animeapp.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AnimeDetails
import ar.edu.uade.c012025.animeapp.ui.screens.commons.CharacterGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.FavoriteButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.Header
import ar.edu.uade.c012025.animeapp.ui.screens.commons.OpeningYoutubePlayer
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RecommendationsSliderAnime
import ar.edu.uade.c012025.animeapp.ui.screens.commons.TrailerYoutubePlayer
import coil.compose.AsyncImage

@Composable
fun AnimeUiItemDetail(anime: Anime, navController: NavHostController, vm: AnimeDetailScreenViewModel = viewModel()) {
        LaunchedEffect(anime.id) {
            vm.loadCharacters(animeId = anime.id)
            vm.loadRecommendations(anime.id)
        }

        val characters = vm.characterList
        val recommendations = vm.recommendationList
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Header(navController)

        // Título del anime
        Text(
            text = "${anime.title} (${anime.titleJapanese})",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Imagen y descripción
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            AsyncImage(
                model = anime.images.jpg.imageUrl,
                contentDescription = anime.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = anime.synopsis,
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = 22.sp,
                modifier = Modifier.weight(1f)
            )
        }

        // Botón de favoritos
        FavoriteButton()

        // Trailer
        TrailerYoutubePlayer(youtubeUrl = "https://www.youtube.com/watch?v=XQr7LvFZrlE")

        // Columnas de detalles y personajes
        Row(modifier = Modifier.padding(16.dp)) {
            // Columna Izquierda
            Column(modifier = Modifier.weight(1f)) {
                AnimeDetails(anime)
                OpeningYoutubePlayer("https://www.youtube.com/watch?v=9TRemrRaPjc")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Columna Derecha
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Personajes principales",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                CharacterGrid( personajes = characters)
            }
        }

        // Recomendaciones
        Divider()
        Text(
            "Si te gusta este título, quizás te guste:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        RecommendationsSliderAnime(animes = recommendations)
    }
}