package org.sessac.utils

import java.io.File

object FileUtils {
    fun saveToFile(fileName: String, content: List<String>) {
        val file = File(fileName)
        file.printWriter().use { out ->
            content.forEach { line -> out.println(line) }
        }
    }

    fun loadFromFile(fileName: String): List<String>? {
        val file = File(fileName)
        return if (file.exists()) {
            file.readLines()
        } else {
            null
        }
    }
}