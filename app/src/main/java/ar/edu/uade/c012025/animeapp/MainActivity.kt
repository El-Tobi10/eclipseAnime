package ar.edu.uade.c012025.animeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ar.edu.uade.c012025.animeapp.ui.screens.NavigationStack
import ar.edu.uade.c012025.animeapp.ui.screens.animelist.AnimeListScreen
import ar.edu.uade.c012025.animeapp.ui.theme.AnimeAppTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack()
                }
            }
        }
    }
}


