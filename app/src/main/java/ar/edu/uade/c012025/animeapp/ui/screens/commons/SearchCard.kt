package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.SearchItem
import ar.edu.uade.c012025.animeapp.data.SearchItemType
import coil.compose.AsyncImage

@Composable
fun SearchCard(item: SearchItem, navController : NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable {
                when (item.type) {
                    SearchItemType.EPISODE-> navController.navigate("anime_detail_screen/${item.id}")
                    SearchItemType.ANIME-> navController.navigate("anime_detail_screen/${item.id}")
                    SearchItemType.MANGA -> navController.navigate("manga_detail_screen/${item.id}")
                }
            }
    ) {
        Box {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))

            )
        }

        Text(item.title, style = MaterialTheme.typography.bodyLarge)


    }
}
