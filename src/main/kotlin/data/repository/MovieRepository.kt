package org.sessac.data.repository

import org.sessac.data.model.MovieManager
import org.sessac.data.model.Seat
import org.sessac.data.model.SeatStatus
import org.sessac.utils.FileUtils

class MovieRepository {
    fun saveMovie(movieManager: MovieManager) {
        val content = movieManager.seats.map { row ->
            row.joinToString(",") { it.status.name }
        }
        FileUtils.saveToFile("${movieManager.title.replace(" ", "_")}_seats.txt", content)
    }

    fun loadMovie(title: String, emoji: String, rows: Int, cols: Int): MovieManager {
        val seats = Array(rows) { row -> Array(cols) { col -> Seat(row, col) } }
        val movieManager = MovieManager(title, emoji, seats)
        val content = FileUtils.loadFromFile("${title.replace(" ", "_")}_seats.txt")
        content?.forEachIndexed { rowIndex, line ->
            val statuses = line.split(",")
            statuses.forEachIndexed { colIndex, status ->
                seats[rowIndex][colIndex].status = SeatStatus.valueOf(status)
            }
        }
        return movieManager
    }
}