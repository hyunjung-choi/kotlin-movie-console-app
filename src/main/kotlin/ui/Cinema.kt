package org.sessac.ui

import org.sessac.data.model.MovieManager
import org.sessac.domain.usecase.MovieUseCase
import org.sessac.utils.*

class Cinema(private val useCase: MovieUseCase, private val movieManagers: List<MovieManager>) {

    fun start() {
        ArtUtils.printCinemaArt()
        showWelcomeMessage()
        val selectedMovie = selectMovie()

        selectedMovie?.let {
            showSeats(it)
            selectSeat(it)
            showFinalSeatArrangement(it)
        } ?: run {
            println("${RED}잘못된 선택이에요. 다시 시도해 주세요!${RESET}")
        }
    }

    private fun showWelcomeMessage() {
        println("${CYAN}새싹 영화관에 오신 걸 환영해요!${RESET}")
        println("${PURPLE}보고 싶은 영화를 골라주세요:${RESET}")
    }

    private fun selectMovie(): MovieManager? {
        movieManagers.forEachIndexed { index, movie -> println("${movie.emoji} ${index + 1}. ${movie.title}") }
        val choice = InputUtils.getValidatedIntInput("\n${YELLOW}영화 번호를 입력해주세요: ${RESET}", 1, movieManagers.size)
        return movieManagers[choice - 1]
    }

    private fun showSeats(selectedMovieManager: MovieManager) {
        println("\n${GREEN}선택한 영화: ${selectedMovieManager.emoji} ${selectedMovieManager.title}${RESET}\n")
        ArtUtils.printSeatArt()
        println("${BLUE}예매 가능한 좌석을 확인해 주세요 (\uD83D\uDFE9 = 예약 가능, \uD83D\uDFE5 = 예약됨):${RESET}")
        selectedMovieManager.displaySeats()
    }

    private fun selectSeat(movieManager: MovieManager) {
        val row = InputUtils.getIntInput("\n${YELLOW}행 번호를 입력해주세요: ${RESET}") - 1
        val col = InputUtils.getIntInput("${YELLOW}열 번호를 입력해주세요: ${RESET}") - 1

        if (movieManager.bookSeat(row, col)) {
            ArtUtils.printConfirmationArt()
            useCase.saveMovie(movieManager)
            println("\n${GREEN}예매가 완료되었어요! 즐거운 영화 관람 되세요! 🍿✨${RESET}")
        } else {
            println("${RED}잘못된 좌석 선택이거나 이미 예약된 좌석이에요!${RESET}")
        }
    }

    private fun showFinalSeatArrangement(movieManager: MovieManager) {
        println("\n${BLUE}최종 좌석 배치:${RESET}")
        movieManager.displaySeats()
    }
}