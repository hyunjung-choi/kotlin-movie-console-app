package domain.repository

import data.datasourceimpl.MovieManager
import domain.model.MovieInfo

interface MovieRepository {
    fun getAllMovies(): List<MovieInfo>
    suspend fun saveMovie(movieManager: MovieManager)
    suspend fun loadMovie(movieInfo: MovieInfo): MovieManager
    suspend fun loadSeatsFromFile(movieManager: MovieManager)
    suspend fun checkBookingInfo(movieInfo: MovieInfo): MovieManager
    suspend fun saveBookingInfo(bookedSeats: MovieInfo)
    suspend fun getBookingInfo(): List<String>
}