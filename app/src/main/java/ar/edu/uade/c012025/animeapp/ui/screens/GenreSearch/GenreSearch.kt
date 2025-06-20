package ar.edu.uade.c012025.animeapp.ui.screens.GenreSearch


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AssistChip
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.uade.c012025.animeapp.data.GenreData

@Composable
fun GenreSearch(genres: List<GenreData>, selectedGenreId: Int?, onClick: (GenreData) -> Unit) {
    LazyRow {
        items(genres) { genre ->
            val isSelected = genre.id == selectedGenreId
            AssistChip(
                onClick = { onClick(genre) },
                label = { Text(genre.name) },
                modifier = Modifier.padding(4.dp),
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                )

            )
        }
    }
}