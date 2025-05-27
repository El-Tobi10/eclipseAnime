package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Manga
import coil.compose.AsyncImage

@Composable
fun RecommendationsSliderAnime(animes: List<Anime>, navController: NavHostController) {
    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(animes.size) { index ->
            val animes = animes[index]
            Column(horizontalAlignment = Alignment.CenterHorizontally
                , modifier = Modifier.padding(8.dp)
                    .clickable{
                        navController.navigate("anime_detail_screen/${animes.id}")
                    }
            ) {
                AsyncImage(
                    model = animes.images?.jpg?.imageUrl,
                    contentDescription = animes.title,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Text(animes.title, modifier = Modifier.width(120.dp))
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun RecommendationsSliderManga(mangas: List<Manga>, navController: NavHostController) {
    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(mangas.size) { index ->
            val manga = mangas[index]
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = manga.images.jpg?.imageUrl,
                    contentDescription = manga.title,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable{
                            navController.navigate("manga_detail_screen/${manga.id}")
                        }
                )
                Text(manga.title, modifier = Modifier.width(120.dp))
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

