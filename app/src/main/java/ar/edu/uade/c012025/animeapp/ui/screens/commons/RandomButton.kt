package ar.edu.uade.c012025.animeapp.ui.screens.commons


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.AnimeApiDataSource
import ar.edu.uade.c012025.animeapp.data.MangaApiDataSource
import kotlinx.coroutines.launch

@Composable
fun RandomButton(text: String,
                 color: Color,
                 navController: NavHostController,
                 modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val animeApiDataSource = remember { AnimeApiDataSource() }
    val mangaApiDataSource = remember { MangaApiDataSource() }
    Button(
        onClick = {
            scope.launch {
                try {
                    if (text.contains("Manga", ignoreCase = true)) {
                        val manga = mangaApiDataSource.getRandomManga()
                        if (manga.id != 0) {
                            navController.navigate("manga_detail_screen/${manga.id}")
                        }
                    } else {
                        val anime = animeApiDataSource.getRandomAnime()
                        if (anime.id != 0) {
                            navController.navigate("anime_detail_screen/${anime.id}")
                        }
                    }
                } catch (e: Exception) {
                    Log.e("Navigation", "Error fetching random item", e)
                }
            }
            },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
    ) {
        Text( text= text,
            color = MaterialTheme.colorScheme.onPrimary)
    }
}