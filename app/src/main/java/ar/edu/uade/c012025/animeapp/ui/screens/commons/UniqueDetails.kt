package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Manga

@Composable
fun AnimeDetails(anime: Anime) {
    Column {
        Text("Estudio/s: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(anime.studios.joinToString { it.name })
        Text("Año de Publicacion: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text("${anime.year ?: "-"}")
        Text("Puntuacion: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text("${anime.score ?: "-"}")
        Text("Rating: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(anime.rating ?: "-")
        Text("Episodios: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text("${anime.episodes ?: "-"}")
        Text("Duración: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(anime.duration ?: "-")
        Text("Géneros: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(anime.genres.joinToString { it.name })
        Text("Estado: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(anime.status ?: "-")
        if (anime.streaming.isNotEmpty()) {
            Text("Ver en: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
            Text(anime.streaming.joinToString { it.name })
        }
    }
}
@Composable
fun MangaDetails(manga: Manga) {
    Column {
        Text("Puntuacion: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text("${manga.score ?: "-"}")
        Text("Publicacion: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(manga.published?.string ?: "-")
        Text("Géneros: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(manga.genres.joinToString { it.name })
        Text("Estado: ", color = MaterialTheme.colorScheme.secondary, textDecoration = TextDecoration.Underline)
        Text(manga.status ?: "-")
    }
}
