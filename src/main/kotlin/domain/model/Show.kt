package org.sessac.domain.model

import domain.model.Movie
import domain.repository.Theater
import java.time.LocalDateTime

data class Show(
    val movie: Movie,
    val theater: Theater,
    val showTime: LocalDateTime
)
