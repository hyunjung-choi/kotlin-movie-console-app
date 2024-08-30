package org.sessac.ui

import org.sessac.utils.Message
import org.sessac.utils.type.ConsoleType

class OutputView {
    init {
        println(Message.CHOOSE_MENU)
    }

    fun showMenu() {
        showMovieBooking()
        showBookingInfo()
    }

    private fun showMovieBooking() {
        println("${ConsoleType.MOVIE_BOOKING.menuNum}. ${ConsoleType.MOVIE_BOOKING.questionMessage}")
    }

    private fun showBookingInfo() {
        println("${ConsoleType.CHECK_BOOKING_INFO.menuNum}. ${ConsoleType.CHECK_BOOKING_INFO.questionMessage}")
    }
}