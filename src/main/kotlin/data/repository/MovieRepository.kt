package org.sessac.data.repository

import domain.model.MovieInfo
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

    fun loadMovie(movieInfo: MovieInfo): MovieManager {
        val seats = Array(movieInfo.rows) { row -> Array(movieInfo.cols) { col -> Seat(row, col) } }
        val movieManager = MovieManager(movieInfo.title, movieInfo.emoji, seats)
        val content = FileUtils.loadFromFile("${movieInfo.title.replace(" ", "_")}_seats.txt")
        content?.forEachIndexed { rowIndex, line ->
            val statuses = line.split(",")
            statuses.forEachIndexed { colIndex, status ->
                seats[rowIndex][colIndex].status = SeatStatus.valueOf(status)
            }
        }
        return movieManager
    }
}