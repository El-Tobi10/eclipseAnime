package ar.edu.uade.c012025.animeapp.ui.screens.AnimeFavs

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

fun eliminarFavorito(id: Int) {
    val db = FirebaseFirestore.getInstance()

    db.collection("favoritos")
        .document(id.toString())
        .delete()
        .addOnSuccessListener {
            Log.d("Favoritos", "Eliminado correctamente")
        }
        .addOnFailureListener { e ->
            Log.e("Favoritos", "Error al eliminar", e)
        }
}
