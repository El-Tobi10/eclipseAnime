package ar.edu.uade.c012025.animeapp.ui.screens

sealed class Screens(val route: String) {
    object Splash: Screens("splash")
    object Index: Screens("home_screen")
    object AnimeList: Screens("anime_list_screen")
    object AnimeDetail: Screens("anime_detail_screen")
    object MangaDetail: Screens("manga_detail_screen")
    object FAQ: Screens("faq_screen")
    object Login: Screens("login_screen")
    object CharacterDetail: Screens("character_detail_screen")
    object Favs: Screens("favs_screen")
    object Mangas: Screens("mangas_screen")
    object Animes: Screens("animes_screen")

}