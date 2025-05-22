package ar.edu.uade.c012025.animeapp.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import ar.edu.uade.c012025.animeapp.ui.screens.Screens

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
)
{
    LaunchedEffect(Unit) {
        delay(2000) // Espera 2 segundos
        navController.navigate(Screens.AnimeList.route) {
            popUpTo("splash") { inclusive = true } // evita volver atrás
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1F1B24)), // fondo oscuro temático anime
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen central
            AsyncImage(
                model = "https://cdn-icons-png.flaticon.com/512/8144/8144787.png", // o tu logo
                contentDescription = "Logo Anime",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Anime Explorer",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Descubrí tus series favoritas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
    }
}