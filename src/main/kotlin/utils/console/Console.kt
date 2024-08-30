package utils.console

import java.util.*

object Console {
    private val scanner: Scanner by lazy {
        Scanner(System.`in`)
    }

    fun readLine(): String = scanner.nextLine()

    fun close() {
        scanner.close()
    }
}
