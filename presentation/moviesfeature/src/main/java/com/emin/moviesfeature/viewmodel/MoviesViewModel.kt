package com.emin.moviesfeature.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emin.common.utils.Resource
import com.emin.model.Movie
import com.emin.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import com.emin.common.utils.OneTimeEvent
import com.emin.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {
    private val _moviesUiState = MutableStateFlow(UiState<List<Movie>>(data = emptyList()))
    val moviesUiState: StateFlow<UiState<List<Movie>>>
        get() = _moviesUiState.asStateFlow()

    init {
        getMovies( "batman")
    }

    private fun getMovies(search: String) {
        getMoviesUseCase.executeGetMovies(search)
            .map { resource ->
                when (resource) {
                    is Resource.Loading -> UiState(data = null, loading = true)
                    is Resource.Success -> UiState(data = resource.data)
                    is Resource.Error -> UiState(data = null, error = OneTimeEvent(resource.error))
                }
            }
            .onEach { state -> _moviesUiState.update { state as UiState<List<Movie>> } }
            .catch { e -> _moviesUiState.value = UiState(data = null, error = OneTimeEvent(e)) }
            .launchIn(viewModelScope)
    }

    fun onEvent(event : MoviesEvent) {
        when(event) {
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
        }
    }
}