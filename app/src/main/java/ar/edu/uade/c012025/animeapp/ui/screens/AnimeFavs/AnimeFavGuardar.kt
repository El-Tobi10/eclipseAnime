package ar.edu.uade.c012025.animeapp.ui.screens.AnimeFavs

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun guardarFavorito(animeId: Int, animeName: String, type: String) {
    val db = FirebaseFirestore.getInstance()
    val user = FirebaseAuth.getInstance().currentUser

    user?.let {
        val favorito = hashMapOf(
            "id" to animeId,
            "mail" to it.email,
            "name" to animeName,
            "type" to type
        )

        db.collection("favoritos")
            .document(animeId.toString()) // podés usar ID único por usuario si querés
            .set(favorito)
            .addOnSuccessListener {
                Log.d("Favoritos", "Agregado correctamente")
            }
            .addOnFailureListener { e ->
                Log.e("Favoritos", "Error al agregar", e)
            }
    }
}
