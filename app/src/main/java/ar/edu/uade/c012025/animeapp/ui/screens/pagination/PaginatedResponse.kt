package ar.edu.uade.c012025.animeapp.ui.screens.pagination

import ar.edu.uade.c012025.animeapp.data.Pagination

interface PaginatedResponse<T> {
    val pagination: Pagination
    val data: List<T>
}