package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Manga

@Composable
fun AnimeDetails(anime: Anime) {
    Column {
        Text("Puntuacion: ${anime.score ?: "-"}")
        Text("Rating: ${anime.rating ?: "-"}")
        Text("Episodios: ${anime.episodes ?: "-"}")
        Text("Duración: ${anime.duration ?: "-"}")
        Text("Géneros: ${anime.genres.joinToString { it.name }}")
        Text("Estado: ${anime.status ?: "-"}")
        Text("Ver en: ${anime.streaming.joinToString { it.name }}")
    }
}
@Composable
fun MangaDetails(manga: Manga) {
    Column {
        Text("Puntuacion: ${manga.score ?: "-"}")
        Text("Publicacion: ${manga.published ?: "-"}")
        Text("Géneros: ${manga.genres.joinToString { it.name }}")
        Text("Estado: ${manga.status ?: "-"}")
    }
}
