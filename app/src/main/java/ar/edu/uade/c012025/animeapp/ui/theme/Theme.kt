package ar.edu.uade.c012025.animeapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// 🎨 Paleta de colores personalizada
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF9A68C1),       // Botones principales, ítems destacados
    onPrimary = Color(0xFF1E1B2E),     // Texto sobre color primario
    secondary = Color(0xFFFF77E9),     // Detalles, acentos
    onSecondary = Color(0xFF1E1B2E),   // Texto sobre secundario
    background = Color(0xFF1E1B2E),    // Fondo principal
    onBackground = Color(0xFFF3EFFF),  // Texto sobre fondo
    surface = Color(0xFF2C2541),       // Tarjetas, bloques secundarios
    onSurface = Color(0xFFF3EFFF),     // Texto sobre surface
    error = Color(0xFFFF6B6B),
    onError = Color.Black
)

// 🖋️ Tipografías si querés personalizar
private val AppTypography = Typography()

// ⬛ Tema principal
@Composable
fun EclipseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = AppTypography,
        content = content
    )
}
