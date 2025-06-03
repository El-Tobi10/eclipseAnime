package ar.edu.uade.c012025.animeapp.ui.screens.FaqScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.commons.DrawerContent
import ar.edu.uade.c012025.animeapp.ui.screens.commons.HeaderIndex
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun FaqScreen(navController : NavHostController, authViewModel: AuthViewModel = viewModel()) {
    val faqItems = listOf(
        "¿Qué puedo hacer con Eclipse?" to "Navegá el multiverso otaku: sinopsis, personajes, trailers, openings y plataformas para ver anime o leer manga. Todo en un solo lugar ✨",
        "¿Puedo ver anime desde Eclipse?" to "No directamente, pero te llevamos a donde se ve de forma oficial y con una exelente calidad 🖥️🔥",
        "¿Y los mangas, los puedo leer acá?" to "No. Pero te muestra enlaces seguros y legales para hacerlo.",
        "¿La info se actualiza sola?" to "¡Sí!, la app consume datos directamente desde MyAnimeList, que mantiene información actualizada.",
        "¿Puedo armar mi lista de favoritos?" to "¡Sí! Guardá tus animes y mangas fav y volvé a ellos como si fueran tu arco de relleno preferido 😎",
        "¿La app es gratuita?" to "100% gratis. Lo único que podés necesitar son cuentas en los servicios externos si querés ver/leer desde ahí.",
        "¿Puedo sugerir nuevos títulos?" to "¡Claro! Mandanos tu sugerencia desde la app y ayudanos a hacer crecer Eclipse con tus favoritos 💌✨"
    )
    val user by authViewModel.user.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                user = user,
                onNavigate = { route ->
                    navController.navigate(route)
                    scope.launch { drawerState.close() }
                },
                onLogout = {
                    authViewModel.logOut()
                    navController.navigate("login_screen") {
                        popUpTo(0)
                    }
                }
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 16.dp),
        ) {
            item{HeaderIndex(navController = navController, onMenuClick = { scope.launch { drawerState.open() } })}
            item {
                Text(
                    text = "❓ Preguntas Frecuentes",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(faqItems.size) { index ->
                val question = faqItems[index].first
                val answer = faqItems[index].second
                FaqItem(question = question, answer = answer)
            }
        }
    }
}
@Composable
fun FaqItem(question: String, answer: String) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { expanded = !expanded }
            .animateContentSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.titleMedium
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Expandir",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
//        Text(text = question, style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(text = Icons.Default.ArrowDropDown, textAlign = End)

        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = answer, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
