package menu.controller

import menu.view.MenuView
import menu.domain.InputValidator
import menu.domain.MenuService
import menu.model.NumberBasket
import menu.resources.Messages.*

class MenuController(
    private val menuView: MenuView,
    private val validator: InputValidator,
    private val menuService: MenuService
) {
    fun pickMenuStart() {
//        val numberBasket = generateNumberBasket()
        menuView.showMessage(MENU_PICK_START_HEADER.message())
        val names = readNamesWithRetry(NAME_INPUT_HEADER.message())
        println(names)
//        announceSumNumbers(numberBasket)
    }

    private fun readNamesWithRetry(infoMessage: String): List<String> {
        while (true) {
            try {
                menuView.showMessage(infoMessage)
                val names = menuView.readLine().split(',')
                validator.validateNames(names)
                return names
            } catch (e: IllegalArgumentException) {
                menuView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun readNumberWithRetry(infoMessage: String) {
        while (true) {
            try {
                menuView.showMessage(infoMessage)
                validator.validateInteger(menuView.readLine())
            } catch (e: IllegalArgumentException) {
                menuView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun announceSumNumbers(numberBasket: NumberBasket) {
        val expression = menuService.getExpression(numberBasket)
        val sumValue = menuService.plusTwoNumber(numberBasket)
        menuView.showMessage(SUM_RESULT.formattedMessage(expression, sumValue))
    }

    companion object {
        fun create(): MenuController {
            val menuView = MenuView()
            val inputValidator = InputValidator()
            val menuService = MenuService()
            return MenuController(menuView, inputValidator, menuService)
        }

        val 일식 = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        val 한식 = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        val 중식 = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        val 아시안 = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
        val 양식 = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    }
}