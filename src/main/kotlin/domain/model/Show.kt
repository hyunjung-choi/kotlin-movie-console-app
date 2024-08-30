package org.sessac.domain.model

import domain.repository.Theater
import org.sessac.data.model.Movie
import java.time.LocalDateTime

data class Show(
    val movie: Movie,
    val theater: Theater,
    val showTime: LocalDateTime
)
