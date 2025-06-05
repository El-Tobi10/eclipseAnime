package ar.edu.uade.c012025.animeapp.ui.screens.pagination

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class PaginatedListViewModel<T, R : PaginatedResponse<T>> : ViewModel() {

    var items by mutableStateOf<List<T>>(emptyList())
        protected set

    private var currentPage = 1
    private var isLoading = false
    private var hasNextPage = true

    init {
        loadNextPage()
    }

    fun loadNextPage() {
        if (isLoading || !hasNextPage) return

        isLoading = true
        viewModelScope.launch {
            try {
                val response = fetchPage(currentPage)
                items = items + response.data
                hasNextPage = response.pagination.hasNextPage
                currentPage++
            } catch (e: Exception) {
                Log.e("PaginatedListViewModel", "Error loading page", e)
            } finally {
                isLoading = false
            }
        }
    }

    protected abstract suspend fun fetchPage(page: Int): R
}
