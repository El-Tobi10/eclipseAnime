package ar.edu.uade.c012025.animeapp.ui.screens.commons

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TrailerYoutubePlayer(youtubeUrl: String) {
    AndroidView(
        factory = {
            WebView(it).apply {
                settings.javaScriptEnabled = true
                loadUrl(youtubeUrl.replace("watch?v=", "embed/"))
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    )
}


@Composable
fun OpeningYoutubePlayer(youtubeUrl: String) {
    TrailerYoutubePlayer(youtubeUrl)
}