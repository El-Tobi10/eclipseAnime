package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.uade.c012025.animeapp.data.SearchItem
import coil.compose.AsyncImage

@Composable
fun SearchUIList(
    list: List<SearchItem>,
    modifier: Modifier = Modifier,
    onClick: (SearchItem) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(8.dp)
    ) {
        items(list.size) { index ->
            val item = list[index]
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable{onClick(item)}
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = item.title,
                    modifier = Modifier.size(130.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column {
                    Text(text = "[${item.type}]",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                    Text(text = item.title,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}