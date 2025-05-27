package ar.edu.uade.c012025.animeapp.ui.screens.commons

import android.content.Intent
import android.net.Uri
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun OpeningSearchButton(youtubeSearchUrl: String){
    val context = LocalContext.current
    Button(onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeSearchUrl))
        context.startActivity(intent)
    }) {
        Text("Buscar Opening en YouTube")
    }
}