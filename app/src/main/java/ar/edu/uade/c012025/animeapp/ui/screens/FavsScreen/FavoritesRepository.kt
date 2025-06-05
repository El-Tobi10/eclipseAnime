package ar.edu.uade.c012025.animeapp.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

class FavoritesRepository(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    suspend fun toggleFavorite(email: String, item: SearchItem) {
        val docRef = db.collection("favoritos").document(email)
        val snapshot = docRef.get().await()

        val favorites = snapshot.toObject(FavoritesWrapper::class.java) ?: FavoritesWrapper()

        val updatedList = when (item.type) {
            SearchItemType.ANIME -> {
                val current = favorites.animes.toMutableList()
                if (current.any { it.id == item.id }) {
                    current.removeAll { it.id == item.id }
                } else {
                    current.add(item)
                }
                favorites.copy(animes = current)
            }
            SearchItemType.MANGA -> {
                val current = favorites.mangas.toMutableList()
                if (current.any { it.id == item.id }) {
                    current.removeAll { it.id == item.id }
                } else {
                    current.add(item)
                }
                favorites.copy(mangas = current)
            }
            else -> favorites
        }

        docRef.set(updatedList, SetOptions.merge())
    }

    suspend fun isFavorite(email: String, item: SearchItem): Boolean {
        val snapshot = db.collection("favoritos").document(email).get().await()
        val favorites = snapshot.toObject(FavoritesWrapper::class.java) ?: return false

        return when (item.type) {
            SearchItemType.ANIME -> favorites.animes.any { it.id == item.id }
            SearchItemType.MANGA -> favorites.mangas.any { it.id == item.id }
            else -> false
        }
    }

    suspend fun getFavorites(email: String): List<SearchItem> {
        val snapshot = db.collection("favoritos").document(email).get().await()
        val favorites = snapshot.toObject(FavoritesWrapper::class.java)
        return (favorites?.animes ?: emptyList()) + (favorites?.mangas ?: emptyList())
    }
}

data class FavoritesWrapper(
    val animes: List<SearchItem> = emptyList(),
    val mangas: List<SearchItem> = emptyList()
)
