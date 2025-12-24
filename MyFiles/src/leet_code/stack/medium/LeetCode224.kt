package leet_code.stack.medium


/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it,
and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
such as eval().
 */

fun main() {
    print(
        calculate("(1+(4+5+2)-3)+(6+8)")
    )
}

fun calculate(s: String): Int {
    val stack = ArrayDeque<Int>()

    var result = 0
    var sign = 1
    var i = 0

    while (i < s.length) {
        val ch = s[i]

        when {
            ch == ' ' -> {
                i++
            }

            ch.isDigit() -> {
                var number = 0
                while (i < s.length && s[i].isDigit()) {
                    number = number * 10 + (s[i] - '0')
                    i++
                }
                result += sign * number
            }

            ch == '+' -> {
                sign = 1
                i++
            }

            ch == '-' -> {
                sign = -1
                i++
            }

            ch == '(' -> {
                stack.addLast(result)
                stack.addLast(sign)
                result = 0
                sign = 1
                i++
            }

            else -> {
                val prevSign = stack.removeLast()
                val prevResult = stack.removeLast()
                result = prevResult + prevSign * result
                i++
            }
        }
    }

    return result
}

