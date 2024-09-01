package org.sessac.domain.usecase

import org.sessac.data.model.Movie
import org.sessac.data.repository.MovieRepository

class MovieUseCase(private val repository: MovieRepository) {
    fun saveMovie(movie: Movie) {
        repository.saveMovie(movie)
    }

    fun loadMovie(title: String, emoji: String, rows: Int, cols: Int): Movie {
        return repository.loadMovie(title, emoji, rows, cols)
    }
}