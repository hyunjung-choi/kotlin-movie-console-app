package org.sessac

import data.repositoryimpl.MovieRepositoryImpl
import org.sessac.data.datasource.FileManager
import org.sessac.domain.usecase.MovieUseCase
import org.sessac.ui.InputView
import org.sessac.ui.OutputView
import org.sessac.ui.controller.Controller
import utils.console.Console

fun main() {
    Controller(
        inputView = InputView(),
        outputView = OutputView(),
        movieUseCase = MovieUseCase(MovieRepositoryImpl(FileManager()))
    ).start()

    Console.close()
}