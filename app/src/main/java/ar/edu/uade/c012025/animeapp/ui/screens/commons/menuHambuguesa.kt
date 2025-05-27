package ar.edu.uade.c012025.animeapp.ui.screens.commons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import ar.edu.uade.c012025.animeapp.ui.screens.login.AuthViewModel
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseUser

@Composable
fun AppScaffold(
    navController: NavHostController,
    user: FirebaseUser?,
    authViewModel: AuthViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
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
        Scaffold(
            topBar = {
                Header(
                    navController = navController,
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
            content = { paddingValues ->
                // Acá se pasa correctamente el espacio del topBar
                content(paddingValues)
            }
     )
    }
}
