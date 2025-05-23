package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.uade.c012025.animeapp.data.SearchItem
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

@Composable
fun SearchUIList(
    list: List<SearchItem>,
    modifier: Modifier = Modifier,
    onClick: (SearchItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(list) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(item) }
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = item.title,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = "[${item.type}]")
                    Text(text = item.title)
                }
            }
        }
    }
}