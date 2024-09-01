package org.sessac

import org.sessac.data.repository.MovieRepository
import org.sessac.domain.usecase.MovieUseCase
import org.sessac.ui.Cinema

fun main() {
    val repository = MovieRepository()
    val useCase = MovieUseCase(repository)

    val movies = listOf(
        useCase.loadMovie("바비", "🍿", 5, 5),
        useCase.loadMovie("스파이더맨", "🦸‍♂️", 5, 5),
        useCase.loadMovie("라이온 킹", "👑", 5, 5),
        useCase.loadMovie("해리포터", "🪄", 5, 5)
    )

    val cinema = Cinema(useCase, movies)
    cinema.start()
}