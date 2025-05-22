package ar.edu.uade.c012025.animeapp.ui.screens

sealed class Screens(val route: String) {
    object Splash: Screens("splash")
    object AnimeList: Screens("anime_list_screen")
    object AnimeDetail: Screens("anime_detail_screen")
    object Login: Screens("login_screen")
}