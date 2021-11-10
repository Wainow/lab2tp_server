package com.example.lab2tp

import org.springframework.web.servlet.function.router

data class Game(
    var user1: User?,
    var user2: User?
) {
    fun addUser(user: User): String {
        return if(user1 == null || ( user1 != null && user1!!.name == user.name) ){
            println("game news: old user1: $user1, new user1: $user")
            user1 = user
            checkWinner(user, user2)
        } else if(
            (user2 == null && user1!!.name != user.name) ||
            ( user2 != null && user2!!.name == user.name && user1!!.name != user.name)
        ) {
            println("game news: old user2: $user2, new user2: $user")
            user2 = user
            checkWinner(user, user1)
        } else {
            println("user is incorrect")
            "226"
        }
    }

    private fun checkWinner(user: User, enemy: User?): String {
        return if(user.currentNumber == 42) {
            "42"
        } else if (enemy?.currentNumber == 42) {
            "43"
        } else
            "200"
    }
}