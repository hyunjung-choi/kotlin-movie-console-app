package org.sessac

import data.repository.CheckBookingInfoAction
import data.repository.MovieBookingAction
import data.repository.User
import org.sessac.ui.InputView
import org.sessac.ui.OutputView
import org.sessac.ui.controller.Controller
import util.console.Console

fun main() {
    val user = User("새싹")

    Controller(
        inputView = InputView(),
        outputView = OutputView(),
        movieBookingAction = MovieBookingAction(user),
        checkBookingInfoAction = CheckBookingInfoAction(user),
    ).selectMenu()

    Console.close()
}