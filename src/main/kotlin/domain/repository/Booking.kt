package domain.repository

import org.sessac.domain.model.BookingInfo
import org.sessac.domain.model.Show

interface Booking {
    fun bookTicket(show: Show, seatNumber: Int): Boolean
    fun showBookings(): List<BookingInfo>
}