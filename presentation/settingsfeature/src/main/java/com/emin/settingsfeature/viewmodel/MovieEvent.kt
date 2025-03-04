package com.emin.settingsfeature.viewmodel

sealed class MoviesEvent {
    data class Search(val searchString :String) : MoviesEvent()
}