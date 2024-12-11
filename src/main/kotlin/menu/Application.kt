package menu

import menu.controller.GameController

fun main() {
    val game = GameController.create()
    game.gameStart()
}

