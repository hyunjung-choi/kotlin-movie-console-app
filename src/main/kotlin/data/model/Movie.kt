package org.sessac.data.model

data class Movie(val title: String, val emoji: String, val duration: Int, val seats: Array<Array<Seat>>)