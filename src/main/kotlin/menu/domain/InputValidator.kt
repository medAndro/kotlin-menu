package menu.domain

import menu.resources.Messages.*

class InputValidator {
    fun validateInteger(input: String): Int {
        require(input.isNotBlank()) { EMPTY_INPUT.errorMessage() }
        return input.toIntOrNull() ?: throw IllegalArgumentException(NOT_INTEGER.errorMessage())
    }

    fun validateNames(input: List<String>) {
        require(input.size >= 2) { EMPTY_MIN_PEOPLE.errorMessage() }
        require(input.size <= 5) { EMPTY_MAX_PEOPLE.errorMessage() }
        require(input.size == input.distinct().size) { EMPTY_DUPLICATE_NAME.errorMessage() }

        input.forEach {
            require(it.isNotBlank()) { EMPTY_INPUT.errorMessage() }
            require(it.length >= 2) { EMPTY_MIN_NAME.errorMessage() }
            require(it.length <= 4) { EMPTY_MAX_NAME.errorMessage() }
        }
    }
}