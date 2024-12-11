package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.view.MenuView
import menu.domain.InputValidator
import menu.domain.MenuService
import menu.model.Coach
import menu.resources.Messages.*

class MenuController(
    private val menuView: MenuView,
    private val validator: InputValidator,
    private val menuService: MenuService
) {
    fun pickMenuStart() {
        menuView.showMessage(MENU_PICK_START_HEADER.message())
        val names = readNamesWithRetry(NAME_INPUT_HEADER.message())
        val coaches = readCoaches(names)
        val dailyCategories: MutableList<Int> = mutableListOf()
        dailyCategories.add(dailyCategoryPick(dailyCategories))
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

    private fun readCoaches(names: List<String>): List<Coach> {
        return names.map { coach ->
            readBanMenusWithRetry(coach)
        }
    }

    private fun readBanMenusWithRetry(name: String): Coach {
        while (true) {
            try {
                menuView.showMessage(BAN_MENU_INPUT_HEADER.formattedMessage(name))
                val banMenus = menuView.readLine().split(',')
                validator.validateBanMenus(banMenus)
                return Coach(name, banMenus)
            } catch (e: IllegalArgumentException) {
                menuView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    private fun dailyCategoryPick(categories: MutableList<Int>): Int {
        while (true) {
            val randomVal = Randoms.pickNumberInRange(1, 5)
            val count = categories.count{ it == randomVal }
            if (count <= 1){
                return randomVal
            }
        }
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
        val categories: Map<Int, List<String>> = mapOf(1 to 일식, 2 to 한식, 3 to 중식, 4 to 아시안, 5 to 양식)
        val categoryNames: Map<Int, String> = mapOf(1 to "일식", 2 to "한식", 3 to "중식", 4 to "아시안", 5 to "양식")
    }
}