package menu.resources

enum class Messages(private val message: String) {
    MENU_PICK_START_HEADER("점심 메뉴 추천을 시작합니다.\n"),
    NAME_INPUT_HEADER("코치의 이름을 입력해 주세요. (, 로 구분)"),
    BAN_MENU_INPUT_HEADER("\n%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    SUGGEST_RESULT(
        """
        
        메뉴 추천 결과입니다.
        [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
        """.trimIndent()
    ),
    SUGGEST_RESULT_TAIL("\n추천을 완료했습니다."),

    ERROR("[ERROR] %s"),
    EMPTY_INPUT("입력값이 비어있습니다."),
    EMPTY_MIN_PEOPLE("코치는 최소 2명 이상 입력해야 합니다."),
    EMPTY_MAX_PEOPLE("코치는 최대 5명 이하로 입력해야 합니다."),
    EMPTY_MIN_NAME("이름은 최소 2글자 이상 입력해야 합니다."),
    EMPTY_MAX_NAME("이름은 최대 5글자 이하로 입력해야 합니다."),
    EMPTY_MAX_BAN_FOOD("금지 음식은 2개 이하로 입력해야 합니다."),
    EMPTY_DUPLICATE_NAME("중복된 이름이 존재합니다."),
    INVALID_ERROR("알 수 없는 오류가 발생했습니다.");

    fun message(): String = message
    fun errorMessage(): String = ERROR.formattedMessage(message)
    fun formattedMessage(vararg args: Any): String = String.format(message, *args)
}
