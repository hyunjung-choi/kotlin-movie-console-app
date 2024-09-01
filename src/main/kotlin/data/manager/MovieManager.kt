package org.sessac.data.manager

import domain.repository.MovieAction
import org.sessac.data.datasource.FileManager
import org.sessac.data.model.Seat
import org.sessac.data.model.SeatStatus
import org.sessac.utils.ArtUtils

class MovieManager(
    val title: String,
    val emoji: String,
    val seats: Array<Array<Seat>>,
    private val fileManager: FileManager
) : MovieAction {

    override fun displaySeats() {
        seats.forEach { row ->
            row.forEach { seat -> print("${seat.display()} ") }
            println()
        }
    }

    override fun bookSeat(row: Int, col: Int): Boolean {
        return if (row in seats.indices && col in seats[row].indices && seats[row][col].status == SeatStatus.AVAILABLE) {
            seats[row][col].book()
            saveMovie() // 좌석 예약 후 저장
            true
        } else {
            false
        }
    }

    override fun getSeatArt() {
        ArtUtils.printSeatArt()
    }

    override fun saveMovie() {
        val content = seats.map { row ->
            row.joinToString(",") { it.status.name }
        }
        fileManager.saveToFile("${title.replace(" ", "_")}_seats.txt", content)
    }
}
