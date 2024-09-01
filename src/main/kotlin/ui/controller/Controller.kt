package org.sessac.ui.controller

import domain.model.MovieInfo
import kotlinx.coroutines.runBlocking
import org.sessac.domain.usecase.MovieUseCase
import org.sessac.ui.InputView
import org.sessac.ui.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val movieUseCase: MovieUseCase
) {
    fun start() = runBlocking {
        outputView.printCinemaArt()
        while (true) {
            outputView.showMenu()
            when (inputView.chooseMenu()) {
                "1" -> handleMovieBooking()
                "2" -> getBookingInfo()
                "0" -> break
                else -> outputView.showInvalidInputMessage()
            }
        }
    }

    private suspend fun handleMovieBooking() {
        val movieInfos = movieUseCase.getAllMovies()
        val movieIndex = selectMovie(movieInfos)
        if (movieIndex == -1) return

        val movieInfo = movieInfos[movieIndex]
        val movieManager = movieUseCase.loadMovie(movieInfo)

        outputView.printSeatArt()
        movieUseCase.displaySeats(movieManager)

        val row = inputView.getRowNumber() - 1
        val col = inputView.getColumnNumber() - 1
        val success = movieUseCase.bookSeat(movieManager, row, col)

        movieUseCase.displaySeats(movieManager)
        if (success) {
            outputView.showBookingSuccess()
            movieUseCase.saveBookingInfo(
                MovieInfo(movieInfo.title, movieInfo.emoji, row + 1, col + 1)
            )
        } else outputView.showBookingFailure()
    }

    private suspend fun getBookingInfo() {
        val bookingInfo = movieUseCase.getBookingInfo()
        outputView.showBookingInfo(bookingInfo)
    }

    private fun selectMovie(movieInfos: List<MovieInfo>): Int {
        outputView.showMovieList(movieInfos.map { it.emoji + it.title })
        val choice = inputView.getMovieNumber() - 1 // 사용자 입력을 1부터 시작한다고 가정
        return if (choice in movieInfos.indices) choice else -1
    }
}
