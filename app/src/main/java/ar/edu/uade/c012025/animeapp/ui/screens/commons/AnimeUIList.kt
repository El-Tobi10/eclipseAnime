package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import ar.edu.uade.c012025.animeapp.data.Anime

@Composable
fun AnimeUIList(
    list: List<Anime>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier= modifier
    ) {
        items(
            items = list,
            key = { it -> it.id}
        ) {
            anime ->
            AnimeUiItem(anime, onClick= onClick)
        }
    }
}