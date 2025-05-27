package ar.edu.uade.c012025.animeapp.ui.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _user = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val user = _user.asStateFlow()

    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener {
                Log.d("AuthViewModel", "Login con Firebase exitoso")
                _user.value = auth.currentUser
            }
            .addOnFailureListener {
                Log.e("AuthViewModel", "Error al loguearse")
                it.printStackTrace()
            }
    }
    fun logOut() {
        FirebaseAuth.getInstance().signOut()
        _user.value = null
    }
}