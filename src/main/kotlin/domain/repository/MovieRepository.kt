package domain.repository

import domain.model.MovieInfo
import org.sessac.data.manager.MovieManager

interface MovieRepository {
    fun getAllMovies(): List<MovieInfo>
    suspend fun saveMovie(movieManager: MovieManager)
    suspend fun loadMovie(movieInfo: MovieInfo): MovieManager
    suspend fun loadSeatsFromFile(movieManager: MovieManager)
    suspend fun checkBookingInfo(movieInfo: MovieInfo): MovieManager
    suspend fun saveBookingInfo(bookedSeats: MovieInfo)
    suspend fun getBookingInfo(): List<String>
}