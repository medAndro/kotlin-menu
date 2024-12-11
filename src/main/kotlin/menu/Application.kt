package menu

import menu.controller.MenuController

fun main() {
    val lunch = MenuController.create()
    lunch.pickMenuStart()
}
