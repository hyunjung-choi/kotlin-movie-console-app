package data.repository

import domain.repository.MenuAction

class MovieBookingAction(private val user: User) : MenuAction {
    override fun execute() {
        println("영화 예매를 실행합니다.")
//        user.bookTicket()
    }
}
