package menu.domain

import menu.resources.Messages.*

class InputValidator {
    fun validateInteger(input: String): Int {
        require(input.isNotBlank()) { EMPTY_INPUT.errorMessage() }
        return input.toIntOrNull() ?: throw IllegalArgumentException(NOT_INTEGER.errorMessage())
    }
}