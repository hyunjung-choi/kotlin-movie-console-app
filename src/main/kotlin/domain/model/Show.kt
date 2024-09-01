package org.sessac.domain.model

import domain.repository.Theater
import org.sessac.data.model.MovieManager
import java.time.LocalDateTime

data class Show(
    val movieManager: MovieManager,
    val theater: Theater,
    val showTime: LocalDateTime
)
