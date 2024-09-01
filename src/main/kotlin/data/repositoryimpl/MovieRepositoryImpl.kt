package data.repositoryimpl

import data.datasource.MovieInfos.movieInfos
import data.datasourceimpl.MovieManager
import domain.model.MovieInfo
import domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.sessac.data.datasource.FileManager
import org.sessac.data.model.Seat
import org.sessac.data.model.SeatStatus

class MovieRepositoryImpl(
    private val fileManager: FileManager,
) : MovieRepository {
    private val bookedSeatsFile = "booked_seats.txt"

    override fun getAllMovies(): List<MovieInfo> = movieInfos

    override suspend fun saveMovie(movieManager: MovieManager) {
        withContext(Dispatchers.IO) {
            val content = movieManager.seats.map { row ->
                row.joinToString(",") { it.status.name }
            }
            fileManager.saveToFile("${movieManager.title.replace(" ", "_")}_seats.txt", content)
        }
    }

    override suspend fun loadMovie(movieInfo: MovieInfo): MovieManager {
        return withContext(Dispatchers.IO) { // IO 디스패처에서 실행
            val seats = Array(movieInfo.rows) { row -> Array(movieInfo.cols) { col -> Seat(row, col) } }
            val movieManager = MovieManager(movieInfo.title, movieInfo.emoji, seats, fileManager)
            loadSeatsFromFile(movieManager)
            movieManager
        }
    }

    override suspend fun loadSeatsFromFile(movieManager: MovieManager) {
        withContext(Dispatchers.IO) {
            val content = fileManager.loadFromFile("${movieManager.title.replace(" ", "_")}_seats.txt")
            content?.forEachIndexed { rowIndex, line ->
                val statuses = line.split(",")
                statuses.forEachIndexed { colIndex, status ->
                    movieManager.seats[rowIndex][colIndex].status = SeatStatus.valueOf(status)
                }
            }
        }
    }

    override suspend fun checkBookingInfo(movieInfo: MovieInfo): MovieManager {
        return withContext(Dispatchers.IO) {
            val seats = Array(movieInfo.rows) { row -> Array(movieInfo.cols) { col -> Seat(row, col) } }
            val movieManager = MovieManager(movieInfo.title, movieInfo.emoji, seats, fileManager)
            loadSeatsFromFile(movieManager)
            movieManager
        }
    }

    override suspend fun saveBookingInfo(bookedSeats: MovieInfo) {
        withContext(Dispatchers.IO) {
            val bookedList = "[제목]:${bookedSeats.emoji}${bookedSeats.title} [좌석]:${bookedSeats.rows}행${bookedSeats.cols}열"
            fileManager.appendToFile(bookedSeatsFile, listOf(bookedList))
        }
    }

    override suspend fun getBookingInfo(): List<String> = withContext(Dispatchers.IO) {
        fileManager.loadFromFile(bookedSeatsFile) ?: emptyList()
    }
}
