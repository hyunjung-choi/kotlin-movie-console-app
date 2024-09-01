package org.sessac.domain.usecase

import domain.model.MovieInfo
import org.sessac.data.model.MovieManager
import org.sessac.data.repository.MovieRepository

class MovieUseCase(private val repository: MovieRepository) {
    fun saveMovie(movieManager: MovieManager) {
        repository.saveMovie(movieManager)
    }

    fun loadMovie(movieInfo: MovieInfo): MovieManager {
        return repository.loadMovie(movieInfo)
    }
}