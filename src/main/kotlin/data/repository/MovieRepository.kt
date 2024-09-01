package org.sessac.data.repository

import org.sessac.data.model.Movie
import org.sessac.data.model.Seat
import org.sessac.data.model.SeatStatus
import org.sessac.utils.FileUtils

class MovieRepository {
    fun saveMovie(movie: Movie) {
        val content = movie.seats.map { row ->
            row.joinToString(",") { it.status.name }
        }
        FileUtils.saveToFile("${movie.title.replace(" ", "_")}_seats.txt", content)
    }

    fun loadMovie(title: String, emoji: String, rows: Int, cols: Int): Movie {
        val seats = Array(rows) { row -> Array(cols) { col -> Seat(row, col) } }
        val movie = Movie(title, emoji, seats)
        val content = FileUtils.loadFromFile("${title.replace(" ", "_")}_seats.txt")
        content?.forEachIndexed { rowIndex, line ->
            val statuses = line.split(",")
            statuses.forEachIndexed { colIndex, status ->
                seats[rowIndex][colIndex].status = SeatStatus.valueOf(status)
            }
        }
        return movie
    }
}