package org.sessac.ui

import org.sessac.utils.*

class OutputView {
    fun showMenu() {
        println("${CYAN}${Message.CHOOSE_MENU}${RESET}")
        println("${YELLOW}1. 영화 예매${RESET}")
        println("${YELLOW}2. 예약 정보 조회${RESET}")
        println("${RED}0. 종료${RESET}")
    }

    fun showInvalidInputMessage() {
        println("${RED}${Message.ERROR_INPUT_NUM}${RESET}")
    }

    fun showBookingSuccess() {
        printConfirmationArt()
    }

    fun showBookingFailure() {
        println("${RED}좌석 예약에 실패했습니다. 다시 시도하세요.${RESET}")
    }

    fun showLoadingMessage() {
        println("${BLUE}영화 데이터를 불러오는 중...${RESET}")
    }

    fun showMovieInfo(title: String, emoji: String) {
        println("${PURPLE}영화 정보:${RESET} $title $emoji")
    }

    fun showMovieList(titles: List<String>) {
        println("${CYAN}상영중인 영화 목록:${RESET}")
        titles.forEachIndexed { index, title ->
            println("${index + 1}. $title")
        }
    }

    fun printCinemaArt() {
        println(
            """
        $CYAN
        ────────────────────────────
              🎥 새싹 영화관
             ✨ 환영합니다! ✨
        ────────────────────────────
        $RESET
        """.trimIndent()
        )
    }

    fun printConfirmationArt() {
        println(
            """
        $GREEN
        ────────────────────────────
              ✨ 예매 성공! ✨
          즐거운 관람 되세요! (≧◡≦)
        ────────────────────────────
        $RESET
        """.trimIndent()
        )
    }

    fun printSeatArt() {
        println(
            """
        $CYAN
        ──────────────────────────
               🪑좌석 예매
            좌석을 선택해 주세요!
        ──────────────────────────
        $RESET
        """.trimIndent()
        )
    }

    fun showBookingInfo(bookingInfo: List<String>) {
        println("${CYAN}예매 정보 조회${RESET}")
        if (bookingInfo.isEmpty()) {
            println("${RED}예매 내역이 없습니다.${RESET}")
        } else {
            bookingInfo.forEachIndexed { index, info ->
                println("${index + 1}. $info")
            }
        }
    }
}
