package org.sessac.data.model

import org.sessac.utils.ArtUtils
import java.io.BufferedReader
import java.io.File

data class Movie(val title: String, val emoji: String, val seats: Array<Array<Seat>>) {
    companion object {
        fun createMovie(title: String, emoji: String, rows: Int, cols: Int): Movie {
            val seats = Array(rows) { row -> Array(cols) { col -> Seat(row, col) } }
            val movie = Movie(title, emoji, seats)
            movie.loadSeatsFromFile()
            return movie
        }
    }

    fun displaySeats() {
        seats.forEach { row ->
            row.forEach { seat -> print("${seat.display()} ") }
            println()
        }
    }

    fun bookSeat(row: Int, col: Int): Boolean {
        return if (row in seats.indices && col in seats[row].indices && seats[row][col].status == SeatStatus.AVAILABLE) {
            seats[row][col].book()
            saveSeatsToFile()
            true
        } else {
            false
        }
    }

    private fun saveSeatsToFile() {
        File("${title.replace(" ", "_")}_seats.txt").bufferedWriter().use { writer ->
            writer.write(seats.joinToString("\n") { row ->
                row.joinToString(",") { it.status.name }
            })
        }
    }

    private fun loadSeatsFromFile() {
        val content = File("${title.replace(" ", "_")}_seats.txt").bufferedReader().use(BufferedReader::readText)
        println(content)
    }

    fun getSeatArt() {
        ArtUtils.printSeatArt()
    }
}