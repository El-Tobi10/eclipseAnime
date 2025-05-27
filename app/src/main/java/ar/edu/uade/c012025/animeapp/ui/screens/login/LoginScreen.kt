package ar.edu.uade.c012025.animeapp.ui.screens.login


import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.uade.c012025.animeapp.ui.screens.Screens
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.api.ApiException
import kotlin.jvm.java


@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    val context = LocalContext.current
    val user by authViewModel.user.collectAsState()

    LaunchedEffect(user) {
        if (user != null) {
            navController.navigate("home_screen") {
                popUpTo("login_screen") { inclusive = true }
            }
        }
    }


    // Configuro Google incio cecion
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        try {
//            val account = task.getResult(ApiException::class.java)
//            authViewModel.firebaseAuthWithGoogle(account.idToken!!)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            Log.d("LoginScreen", "Cuenta obtenida: ${account.email}, token: ${account.idToken}")

            account.idToken?.let {
                authViewModel.firebaseAuthWithGoogle(it)
            } ?: run {
                Log.e("LoginScreen", "idToken es null!")
            }

        } catch (e: ApiException) {
            Log.e("LoginScreen", "Fallo Google Sign-In", e)
        }
    }

    val signInRequest = remember {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("670060238472-oq7k0bq606snvmtdj333hb97up8b9c6k.apps.googleusercontent.com")
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso).signInIntent
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            AsyncImage(
                model = "https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//logo_completo_invertido.png", // o tu logo
                contentDescription = "Logo Eclipse",
                modifier = Modifier
                    .size(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    launcher.launch(signInRequest)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Text("Iniciar Sesion con Google", color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }

}