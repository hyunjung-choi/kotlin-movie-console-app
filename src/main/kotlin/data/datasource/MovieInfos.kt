package data.datasource

import domain.model.MovieInfo
import org.sessac.utils.COR
import org.sessac.utils.ROW

object MovieInfos {
    val movieInfos: List<MovieInfo> = listOf(
        MovieInfo("바비", "🍿", ROW, COR),
        MovieInfo("스파이더맨", "🦸‍♂️", ROW, COR),
        MovieInfo("라이온 킹", "👑", ROW, COR),
        MovieInfo("해리포터", "🪄", ROW, COR)
    )
}