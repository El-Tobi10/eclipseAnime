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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
        .padding(top = 48.dp)
    ) {

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

        val items = listOf(
            "Inicio" to Screens.Index.route,
            "Animes" to Screens.Animes.route,
            "Mangas" to Screens.Mangas.route,
            "Mis Favoritos" to Screens.Favs.route
        )

        items.forEachIndexed { index, (label, route) ->
            Divider(color = Color.Gray.copy(alpha = 0.3f))
            Text(
                text = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigate(route) }
                    .padding(vertical = 16.dp, horizontal = 20.dp),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )

        }

        Divider(color = Color.Gray.copy(alpha = 0.3f))

        Spacer(modifier = Modifier.weight(1f))

        // FAQ + Cerrar sesión
        Column(modifier = Modifier.padding(40.dp)) {
            Text(
                text = "FAQ",
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigate(Screens.FAQ.route) }
                    .padding(vertical = 12.dp),
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Cerrar Sesión",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLogout() }
                    .padding(vertical = 12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
