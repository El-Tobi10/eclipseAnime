package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
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

@Composable
fun ItemGrid(items: List<SearchItem>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.height(300.dp)
    ) {
        items(items.size) { index ->
            val item = items[index]
            SearchCard(item, navController)
        }

    }
}
