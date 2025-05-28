package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AnimeDetails
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.CharacterGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.FavoriteButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.Header
import ar.edu.uade.c012025.animeapp.ui.screens.commons.OpeningSearchButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RecommendationsSliderAnime
import ar.edu.uade.c012025.animeapp.ui.screens.commons.TrailerYoutubePlayer
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import java.net.URLEncoder

@Composable
fun AnimeUiItemDetail(anime: Anime, navController: NavHostController, vm: AnimeDetailScreenViewModel = viewModel(), authViewModel: AuthViewModel = viewModel()) {
    LaunchedEffect(anime.id) {
        vm.loadCharacters(animeId = anime.id)
        vm.loadRecommendations(anime.id)
    }

    val characters = vm.characterList
    val recommendations = vm.recommendationList

    val opening = anime.theme?.openings?.firstOrNull()
    val query = opening?.replace("\"", "")?.replace(" by ", " ") ?: ""
    val youtubeSearchUrl = "https://www.youtube.com/results?search_query=${URLEncoder.encode(query, "UTF-8")}"

    val user by authViewModel.user.collectAsState()

    Log.d("AnimeDetail", "anime: ${anime.title}, trailer: ${anime.trailer}, theme: ${anime.theme}")

    AppScaffold(
        navController = navController,
        user = user,
        authViewModel = authViewModel
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            // Header
            //Header(navController, onMenuClick = { scope.launch { drawerState.open() } })

            // Título del anime
            Text(
                text = buildString {
                    append(anime.title)
                    anime.titleJapanese?.let {
                        append(" ($it)")
                    }
                },
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            // Imagen y descripción
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                if (!anime.images?.jpg?.imageUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = anime.images?.jpg?.imageUrl,
                        contentDescription = anime.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(150.dp)
                            .height(250.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                var expanded by remember { mutableStateOf(false) }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = anime.synopsis?: "No se encontraron descripciones",
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 22.sp,
                        maxLines = if (expanded) Int.MAX_VALUE else 10,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = if (expanded) "Ver menos" else "Ver más",
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clickable { expanded = !expanded }
                    )
                }
            }

            // Botón de favoritos
            FavoriteButton()

            // Trailer
            //TrailerYoutubePlayer(youtubeUrl = anime.trailer?.youtubeId ?: "")
            if (!anime.trailer?.youtubeId.isNullOrBlank()) {
                TrailerYoutubePlayer(youtubeUrl = anime.trailer!!.youtubeId!!)
            }

            // Columnas de detalles y personajes
            Row(modifier = Modifier.padding(16.dp)) {
                // Columna Izquierda
                Column(modifier = Modifier.weight(1f)) {
                    AnimeDetails(anime)

                    Spacer(modifier = Modifier.height(16.dp))

                    if (query.isNotBlank()) {
                        OpeningSearchButton(youtubeSearchUrl = youtubeSearchUrl)
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Columna Derecha
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Personajes principales",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        textDecoration = TextDecoration.Underline,
                        color = MaterialTheme.colorScheme.secondary
                    )
//
                    CharacterGrid(personajes = characters, navController = navController)
                }
            }

            // Recomendaciones
            Divider()
            Text(
                "Si te gusta este título, quizás te guste:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp),
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colorScheme.secondary
            )
            RecommendationsSliderAnime(animes = recommendations, navController = navController)
        }
    }
}