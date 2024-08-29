package domain.repository

interface Theater {
    val name: String
    val totalSeats: Int
    fun showAvailableSeats(): List<Int>
    fun bookSeat(seatNumber: Int): Boolean
}