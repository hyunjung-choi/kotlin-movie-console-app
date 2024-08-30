package org.sessac.utils

import org.sessac.util.CYAN
import org.sessac.util.GREEN
import org.sessac.util.RESET

object ArtUtils {
    fun printCinemaArt() {
        println(
            """
        $CYAN
        ────────────────────────────
              🎥 새싹 영화관
             ✨ 환영합니다! ✨
               (˵ •̀ ᴗ - ˵ ) ✧
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
}