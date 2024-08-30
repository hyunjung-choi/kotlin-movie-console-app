package org.sessac.data.model

import org.sessac.utils.ArtUtils
import org.sessac.utils.FileUtils

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
        val content = seats.map { row ->
            row.joinToString(",") { it.status.name }
        }
        FileUtils.saveToFile("${title.replace(" ", "_")}_seats.txt", content)
    }

    private fun loadSeatsFromFile() {
        val content = FileUtils.loadFromFile("${title.replace(" ", "_")}_seats.txt")
        content?.forEachIndexed { rowIndex, line ->
            val statuses = line.split(",")
            statuses.forEachIndexed { colIndex, status ->
                seats[rowIndex][colIndex].status = SeatStatus.valueOf(status)
            }
        }
    }

    fun getSeatArt() {
        ArtUtils.printSeatArt()
    }
}