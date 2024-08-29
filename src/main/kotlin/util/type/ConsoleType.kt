package org.sessac.util.type

import org.sessac.util.Message

enum class ConsoleType(
    val menuNum: Int,
    val questionMessage: String = "",
    val showListMessage: String = ""
) {
    MOVIE_BOOKING(
        menuNum = 1,
        questionMessage = Message.MOVIE_BOOKING,
        showListMessage = Message.SHOW_MOVIE_LIST
    ),
    CHECK_BOOKING_INFO(
        menuNum = 2,
        questionMessage = Message.MOVIE_BOOKING_INFO,
        showListMessage = Message.SHOW_BOOKING_INFO
    ),
}