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
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.ui.screens.commons.CharacterGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.FavoriteButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.Header
import ar.edu.uade.c012025.animeapp.ui.screens.commons.MangaDetails
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RecommendationsSliderManga
import coil.compose.AsyncImage

@Composable
fun MangaUiItemDetail(
    manga: Manga,
    navController: NavHostController,
    vm: MangaDetailScreenViewModel = viewModel()
) {
    LaunchedEffect(manga.id) {
        vm.loadCharacters(mangaId = manga.id)
        vm.loadRecommendations(manga.id)
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
            text = "${manga.title} (${manga.titleJapanese})",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Imagen y descripción
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            AsyncImage(
                model = manga.images.jpg.imageUrl,
                contentDescription = manga.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = manga.synopsis,
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = 22.sp,
                modifier = Modifier.weight(1f)
            )
        }

        // Botón de favoritos
        FavoriteButton()

        // Columnas de detalles y personajes
        Row(modifier = Modifier.padding(16.dp)) {
            // Columna Izquierda
            Column(modifier = Modifier.weight(1f)) {
                Text("Volumenes: ${manga.volumes ?: "-"}")
                Text("Capítulos: ${manga.chapters ?: "-"}")
                Text("Autor/es: ${manga.authors.joinToString { it.name }}")
                Text("Editorial/es: ${manga.serializations.joinToString { it.name }}")

                MangaDetails(manga)
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
        RecommendationsSliderManga(mangas = recommendations)
    }
}