package org.sessac.data.datasource

interface MovieAction {
    fun displaySeats()
    fun bookSeat(row: Int, col: Int): Boolean
    fun getSeatArt()
    fun saveMovie()
}