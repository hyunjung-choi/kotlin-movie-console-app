package org.sessac.data.datasource

import java.io.File

class FileManager {
    fun saveToFile(fileName: String, content: List<String>) {
        val file = File(fileName)
        file.printWriter().use { out ->
            content.forEach { line -> out.println(line) }
        }
    }

    fun loadFromFile(fileName: String): List<String>? {
        val file = File(fileName)
        return when (file.exists()) {
            true -> file.bufferedReader().use { bufferReader -> bufferReader.readLines() }
            false -> null
        }
    }

    fun appendToFile(fileName: String, content: List<String>) {
        val file = File(fileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.appendText(content.joinToString(separator = "\n", postfix = "\n"))
    }
}
