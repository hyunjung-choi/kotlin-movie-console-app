package org.sessac.ui

import util.console.Console

class InputView {
    fun chooseMenu(): String {
        println()
        print("해당하는 메뉴 번호(숫자)를 입력해주세요 : ")
        return Console.readLine()
    }
}