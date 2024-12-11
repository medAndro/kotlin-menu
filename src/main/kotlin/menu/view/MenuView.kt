package menu.view

import camp.nextstep.edu.missionutils.Console

class MenuView {
    // Input Views
    fun readLine(): String {
        return Console.readLine()
    }

    // Output Views
    fun showResultCategoryNames(categoryNames: List<String>) {
        val joinNames = categoryNames.joinToString(" | ")
        println("[ 카테고리 | $joinNames ]")
    }

    fun showMessage(message: String) {
        println(message)
    }
}