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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.commons.CharacterGrid
import ar.edu.uade.c012025.animeapp.ui.screens.commons.FavoriteButton
import ar.edu.uade.c012025.animeapp.ui.screens.commons.Header
import ar.edu.uade.c012025.animeapp.ui.screens.commons.MangaDetails
import ar.edu.uade.c012025.animeapp.ui.screens.commons.RecommendationsSliderManga
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun MangaUiItemDetail(
    manga: Manga,
    navController: NavHostController,
    vm: MangaDetailScreenViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
    LaunchedEffect(manga.id) {
        vm.loadCharacters(mangaId = manga.id)
        vm.loadRecommendations(manga.id)
    }

    val characters = vm.characterList
    val recommendations = vm.recommendationList
    val user by authViewModel.user.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    AppScaffold(
        navController = navController,
        user = user,
        authViewModel = authViewModel
    ) { padding ->
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
                text = "${manga.title} (${manga.titleJapanese?: ""})",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            // Imagen y descripción
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                AsyncImage(
                    model = manga.images.jpg?.imageUrl,
                    contentDescription = manga.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(150.dp)
                        .height(250.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(12.dp))

                var expanded by remember { mutableStateOf(false) }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = manga.synopsis?: "No se encontraron descripciones",
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

            // Columnas de detalles y personajes
            Row(modifier = Modifier.padding(16.dp)) {
                // Columna Izquierda
                Column(modifier = Modifier.weight(1f)) {
                    Text("Volumenes: ${manga.volumes ?: "-"}")
                    Text("Capítulos: ${manga.chapters ?: "-"}")
                    Text("Autor/es: ${manga.authors.joinToString { it.name }}")
                    Text("Editorial/es: ${manga.serializations.joinToString { it.name }}")

                    Spacer(modifier = Modifier.height(18.dp))

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
                    Log.d("CharacterGrid", "Characters: $characters")
//                    if (characters.isNotEmpty()) {
//                        CharacterGrid(personajes = characters, navController = navController)
//                    }
                    CharacterGrid(personajes = characters, navController = navController)
                }
            }

            // Recomendaciones
            Divider()
            Text(
                "Si te gusta este título, quizás te guste:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            RecommendationsSliderManga(mangas = recommendations, navController = navController)
        }
    }
}