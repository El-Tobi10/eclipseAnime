package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton() {
    Button(onClick = { /* Guardar en favoritos */ }, modifier = Modifier.padding(16.dp)) {
        Icon(Icons.Default.Star, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Favorito")
    }
}