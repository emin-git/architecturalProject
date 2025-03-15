package com.emin.moviesfeature.viewmodel

sealed class MoviesEvent {
    data class Search(val searchString :String) : MoviesEvent()
}