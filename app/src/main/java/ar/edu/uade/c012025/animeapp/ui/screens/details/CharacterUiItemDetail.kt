package ar.edu.uade.c012025.animeapp.ui.screens.details

import android.R.id.bold
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.ui.screens.commons.AppScaffold
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import coil.compose.AsyncImage

@Composable
fun CharacterUiItemDetail(
    character: CharacterData,
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel()
) {
    val user by authViewModel.user.collectAsState()

    AppScaffold(
        navController = navController,
        user = user,
        authViewModel = authViewModel
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {

            // Nombre
            Text(
                text = "${character.name} (${character.nameKanji?: ""})",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )

            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                // Imagen
                AsyncImage(
                        model = character.images?.jpg?.imageUrl,
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Descripción
                Column {
                    var expanded by remember { mutableStateOf(false) }
                    Text(
                        text = character.about?.toString() ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 22.sp,
                        maxLines = if (expanded) Int.MAX_VALUE else 10,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = if (expanded) "Ver menos" else "Ver más",
                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clickable { expanded = !expanded }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Aparece en animes
            if (character.anime.isNotEmpty()) {
                Text("Aparece en animes:",
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(15.dp),
                    color = MaterialTheme.colorScheme.secondary)
                character.anime.forEach {
                    Text(
                        "- ${it.anime?.title} (Rol: ${it.role})",
                        modifier = Modifier.padding(horizontal = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Aparece en mangas
            if (character.manga.isNotEmpty()) {
                Text("Aparece en mangas:",
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(15.dp),
                    color = MaterialTheme.colorScheme.secondary)
                character.manga.forEach {
                    Text(
                        "- ${it.manga?.title} (Rol: ${it.role})",
                        modifier = Modifier.padding(horizontal = 18.dp)
                    )
                }
            }
        }
    }
}
