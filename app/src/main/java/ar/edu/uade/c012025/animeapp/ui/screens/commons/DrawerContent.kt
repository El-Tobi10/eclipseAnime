package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import ar.edu.uade.c012025.animeapp.ui.screens.Screens
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseUser

@Composable
fun DrawerContent(
    user: FirebaseUser?,
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface)
        .padding(12.dp)) {

        user?.photoUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Text(
            text = user?.displayName ?: "Username",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        DrawerButton("Inicio") { onNavigate(Screens.Index.route) }
        DrawerButton("Animes") { onNavigate(Screens.AnimeList.route) }
        DrawerButton("Mangas") { onNavigate(Screens.AnimeList.route) }
        DrawerButton("Mis Favoritos") { onNavigate(Screens.Index.route) }

        Spacer(modifier = Modifier.weight(1f))

        DrawerButton("FAQ") { onNavigate(Screens.Index.route) }
        DrawerButton("Cerrar Sesión", color = MaterialTheme.colorScheme.error) { onLogout() }
    }
}

@Composable
fun DrawerButton(text: String, color: Color = MaterialTheme.colorScheme.onSurface, onClick: () -> Unit) {
    Text(
        text = text,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center,
    )
}
