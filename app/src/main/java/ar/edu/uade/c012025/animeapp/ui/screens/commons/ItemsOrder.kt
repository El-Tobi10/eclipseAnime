package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ar.edu.uade.c012025.animeapp.data.SearchItem
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ItemRow(items: List<SearchItem>, navController: NavHostController) {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(items.size) { index ->
            val item = items[index]
            SearchCard(item, navController)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemGrid(items: List<SearchItem>, navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(items.size) { index ->
            val item = items[index]
            SearchCard(item, navController)
        }
    }
}
