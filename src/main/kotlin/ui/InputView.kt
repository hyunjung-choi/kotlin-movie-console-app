package org.sessac.ui

import data.datasource.MovieInfos
import org.sessac.utils.*
import utils.console.Console

class InputView {
    private val validMovieRange = 1..MovieInfos.movieInfos.size
    private val rowRange = 1..ROW
    private val colRange = 1..COR

    fun chooseMenu(): String {
        println()
        print("${CYAN}메뉴를 선택하세요: $RESET")
        return Console.readLine()
    }

    fun getRowNumber(): Int = getValidatedIntInput(rowRange) {
        "${GREEN}예약할 좌석의 행 번호를 입력하세요: $RESET"
    }

    fun getColumnNumber(): Int = getValidatedIntInput(colRange) {
        "${GREEN}예약할 좌석의 열 번호를 입력하세요: $RESET"
    }

    fun getMovieNumber(): Int = getValidatedIntInput(validMovieRange) {
        "예매할 영화의 번호를 입력하세요: "
    }

    private fun getValidatedIntInput(range: IntRange, prompt: () -> String): Int {
        while (true) {
            print(prompt())
            try {
                val number = Console.readLine().toInt()
                if (number in range) {
                    return number
                } else {
                    println("${RED}잘못된 입력입니다. 범위는 ${range.first}부터 ${range.last}까지입니다. 다시 시도하세요.$RESET")
                }
            } catch (e: NumberFormatException) {
                println("${RED}잘못된 입력입니다. 숫자를 입력하세요. 다시 시도하세요.$RESET")
            }
        }
    }
}
