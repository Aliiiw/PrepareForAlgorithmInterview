package leet_code.stack.easy

import kotlin.text.iterator


fun main() {
    print(isValid("(]"))

}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (ch in s) {
        when (ch) {
            '(', '[', '{' -> stack.addLast(ch)
            ')', ']', '}' -> {
                if (stack.isEmpty()) return false
                val top = stack.removeLast()
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')
                ) return false
            }
        }
    }

    return stack.isEmpty()
}
