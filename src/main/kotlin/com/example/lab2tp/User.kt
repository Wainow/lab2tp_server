package com.example.lab2tp

data class User(
    var name: String,
    var currentNumber: Int,
    var availableOperations: ArrayList<Operation>,
    var availableNumbers: ArrayList<Int>,
    val result: String = ""
)
