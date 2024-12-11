package menu.domain

import menu.model.NumberBasket

class MenuService {
    fun plusTwoNumber(numberBasket: NumberBasket): Int {
        return numberBasket.getNumbers().sum()
    }

    fun getExpression(numberBasket: NumberBasket): String {
        return numberBasket.getNumbers().joinToString(separator = " + ")
    }
}