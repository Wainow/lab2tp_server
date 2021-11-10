package com.example.lab2tp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@SpringBootApplication
@RestController
class Lab2tpApplication{
	companion object {
		var game = Game(null, null)
	}

	@GetMapping("/game")
	fun getGame(): String? {
		val gameJson = Gson().toJson(game)
		println("game: $gameJson")
		return gameJson
	}

	@PostMapping("/add_user")
	fun addUser(@RequestParam("user")  userJson: String): String {
		val user = GsonBuilder()
			.setLenient()
			.create()
			.fromJson(userJson, User::class.java)
		println("add_user: received user: $user")
		val result = game.addUser(user)
		if(result == "42" && result == "43") {
			game = Game(null, null)
		}
		return result
	}
}

fun main(args: Array<String>) {
	runApplication<Lab2tpApplication>(*args)
}
