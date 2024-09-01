package org.sessac.domain.usecase

import org.sessac.data.model.MovieManager
import org.sessac.data.repository.MovieRepository

class MovieUseCase(private val repository: MovieRepository) {
    fun saveMovie(movieManager: MovieManager) {
        repository.saveMovie(movieManager)
    }

    fun loadMovie(title: String, emoji: String, rows: Int, cols: Int): MovieManager {
        return repository.loadMovie(title, emoji, rows, cols)
    }
}