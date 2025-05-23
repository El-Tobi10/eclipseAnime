package ar.edu.uade.c012025.animeapp.ui.screens.commons


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.Screens

@Composable
fun RandomButton(text: String, color: Color, navController: NavHostController) {
    Button(
        onClick = { navController.navigate(Screens.AnimeList.route)},
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Text( text= text,
            color = MaterialTheme.colorScheme.onPrimary)
    }
}