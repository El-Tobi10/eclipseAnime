package ar.edu.uade.c012025.animeapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.uade.c012025.animeapp.ui.screens.FaqScreen.FaqScreen
import ar.edu.uade.c012025.animeapp.ui.screens.details.AnimeDetailScreen
import ar.edu.uade.c012025.animeapp.ui.screens.animelist.AnimeListScreen
import ar.edu.uade.c012025.animeapp.ui.screens.details.CharacterDetailScreen
import ar.edu.uade.c012025.animeapp.ui.screens.details.MangaDetailScreen
import ar.edu.uade.c012025.animeapp.ui.screens.login.LoginScreen
import ar.edu.uade.c012025.animeapp.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
    )  {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.Index.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.FAQ.route) {
            FaqScreen(navController = navController)
        }
        composable(route = Screens.AnimeList.route) {
            AnimeListScreen(navController = navController)
        }
        composable(route = Screens.AnimeDetail.route + "/{animeId}") { it ->
            var id = it.arguments?.getString("animeId")
            val animeId = id?.toIntOrNull()
            AnimeDetailScreen(animeId ?: 0, navController)
        }
        composable(route = Screens.MangaDetail.route + "/{mangaId}") { it ->
            var id = it.arguments?.getString("mangaId")
            val mangaId = id?.toIntOrNull()
            MangaDetailScreen(mangaId ?: 0, navController)
        }
        composable(route = Screens.CharacterDetail.route + "/{characterId}") { it ->
            var id = it.arguments?.getString("characterId")
            val characterId = id?.toIntOrNull()
            CharacterDetailScreen(characterId ?: 0, navController)
        }

    }

}