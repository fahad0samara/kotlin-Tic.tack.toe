package com.example.tictactoc.data

sealed class UserAction {
    object PlayAgainButtonClicked: UserAction()
    data class BoardTapped(val cellNo: Int): UserAction()
}
