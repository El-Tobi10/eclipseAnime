package ar.edu.uade.c012025.animeapp.ui.screens.commons

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TrailerYoutubePlayer(youtubeUrl: String) {
    AndroidView(factory = { context ->
        val youTubePlayerView = YouTubePlayerView(context)
        val lifecycle = (context as ComponentActivity).lifecycle
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(youtubeUrl, 0f)
            }
        })

        youTubePlayerView
    }, modifier = Modifier
        .fillMaxWidth()
        .height(230.dp)
        .padding(16.dp))
}