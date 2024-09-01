package org.sessac.domain.usecase

import data.datasourceimpl.MovieManager
import domain.model.MovieInfo
import domain.repository.MovieRepository

class MovieUseCase(
    private val movieRepository: MovieRepository
) {
    fun getAllMovies(): List<MovieInfo> = movieRepository.getAllMovies()

    fun displaySeats(movieManager: MovieManager) {
        movieManager.displaySeats()
    }

    suspend fun bookSeat(movieManager: MovieManager, row: Int, col: Int): Boolean {
        val success = movieManager.bookSeat(row, col) // 좌석 예매 시도
        if (movieManager.bookSeat(row, col)) {
            saveMovie(movieManager) // 예매 성공 시 데이터 저장
        }
        return success
    }

    suspend fun checkBookingInfo(movieInfo: MovieInfo): MovieManager {
        return movieRepository.loadMovie(movieInfo)
    }

    fun displaySeatArt(movieManager: MovieManager) {
        movieManager.getSeatArt()
    }

    suspend fun loadMovie(movieInfo: MovieInfo): MovieManager {
        return movieRepository.loadMovie(movieInfo)
    }

    private suspend fun saveMovie(movieManager: MovieManager) {
        movieRepository.saveMovie(movieManager)
    }

    suspend fun getBookingInfo(): List<String> = movieRepository.getBookingInfo()

    suspend fun saveBookingInfo(movieInfo: MovieInfo) {
        movieRepository.saveBookingInfo(movieInfo)
    }
}
