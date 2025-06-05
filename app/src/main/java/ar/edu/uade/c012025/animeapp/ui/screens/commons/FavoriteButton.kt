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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(isFavorite: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ) {
        if (isFavorite){
            Icon(
                imageVector =  Icons.Default.Star,
                contentDescription = "Favorito",
                tint = Color.Yellow
            )
        }else{
            Icon(
                imageVector =  Icons.Default.Star,
                contentDescription = "Favorito",
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (isFavorite) "Quitar Favorito" else "Agregar Favorito")
    }
}