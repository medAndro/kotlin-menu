package menu.model

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String, private val banMenus: List<String>) {
    private var menus: MutableList<String> = mutableListOf()

    fun pickMenu(categoryFoods: List<String>) {
        while (true) {
            val menu: String = Randoms.shuffle(categoryFoods)[0]
            if (menu in banMenus || menu in menus) {
                continue
            }
            menus.add(menu)
            break
        }
    }

    fun getNameWithMenus(): String {
        return "[ $name | ${menus.joinToString(" | ")} ]"
    }
}