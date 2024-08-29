package data.repository

import domain.repository.MenuAction

class CheckBookingInfoAction(private val user: User) : MenuAction {
    override fun execute() {
        println("예약 정보를 조회합니다.")
        user.showBookings()
    }
}
