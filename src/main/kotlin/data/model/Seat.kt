package org.sessac.data.model

data class Seat(val row: Int, val col: Int, var status: SeatStatus = SeatStatus.AVAILABLE) {
    fun book() {
        status = SeatStatus.BOOKED
    }

    fun display(): String {
        return status.display
    }
}