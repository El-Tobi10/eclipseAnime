package ar.edu.uade.c012025.animeapp.ui.screens.AnimeFavs

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun guardarFavorito(id: Int, name: String, type: String) {
    val db = FirebaseFirestore.getInstance()
    val user = FirebaseAuth.getInstance().currentUser

    user?.let {
        val favorito = hashMapOf(
            "id" to id,
            "mail" to it.email,
            "name" to name,
            "type" to type
        )

        db.collection("favoritos")
            .document(id.toString()) // podés usar ID único por usuario si querés
            .set(favorito)
            .addOnSuccessListener {
                Log.d("Favoritos", "Agregado correctamente")
            }
            .addOnFailureListener { e ->
                Log.e("Favoritos", "Error al agregar", e)
            }
    }
}
