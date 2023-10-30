package com.example.tictactoc.model

sealed class UserAction {
    object PlayAgainButtonClicked: UserAction()
    data class BoardTapped(val cellNo: Int): UserAction()
}
