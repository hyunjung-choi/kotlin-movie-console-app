package org.sessac.ui.controller

import domain.repository.MenuAction
import org.sessac.ui.InputView
import org.sessac.ui.OutputView
import org.sessac.util.Message
import org.sessac.util.type.ConsoleType

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val movieBookingAction: MenuAction,  // 영화 예매 동작
    private val checkBookingInfoAction: MenuAction  // 예약 정보 조회 동작
) {
    init {
        outputView.showMenu()
    }

    fun selectMenu() {
        while (true) {
            if (checkMenu()) break
        }
    }

    private fun checkMenu(): Boolean = when (inputView.chooseMenu()) {
        (ConsoleType.MOVIE_BOOKING.menuNum).toString() -> {
            movieBookingAction.execute()
            true
        }

        (ConsoleType.CHECK_BOOKING_INFO.menuNum).toString() -> {
            checkBookingInfoAction.execute()
            true
        }

        else -> {
            println(Message.ERROR_INPUT_NUM)
            false
        }
    }
}