package org.sessac.utils

import org.sessac.util.RED
import org.sessac.util.RESET
import java.util.*

object InputUtils {
    private val scanner = Scanner(System.`in`)

    fun getIntInput(prompt: String): Int {
        print(prompt)
        return scanner.nextInt()
    }

    fun getValidatedIntInput(prompt: String, min: Int, max: Int): Int {
        var input: Int
        do {
            input = getIntInput(prompt)
            if (input !in min..max) {
                println("${RED}잘못된 입력입니다. 다시 시도하세요.$RESET")
            }
        } while (input !in min..max)
        return input
    }
}