package data.repository

import domain.repository.Booking
import org.sessac.domain.model.BookingInfo
import org.sessac.domain.model.Show

class User(val name: String) : Booking {
    private val bookings: MutableList<BookingInfo> = mutableListOf()

    override fun bookTicket(show: Show, seatNumber: Int): Boolean {
        return if (show.theater.bookSeat(seatNumber)) {
            val bookingInfo = BookingInfo(show, seatNumber)
            bookings.add(bookingInfo)
            println("Booking successful for ${show.movieManager.title} at ${show.showTime} in seat $seatNumber")
            true
        } else {
            false
        }
    }

    override fun showBookings(): List<BookingInfo> {
        return bookings
    }
}