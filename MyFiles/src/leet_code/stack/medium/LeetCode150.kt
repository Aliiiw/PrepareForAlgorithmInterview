package leet_code.stack.medium


/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */

fun main() {
    print(
        evalRPN(arrayOf("2", "1", "+", "3", "*"))
    )
}

fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()

    tokens.forEach { token ->
        when (token) {
            "+", "-", "*", "/" -> {
                val b = stack.removeLast()
                val a = stack.removeLast()

                val result = when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    else -> a / b
                }

                stack.addLast(result)
            }

            else -> {
                stack.addLast(token.toInt())
            }
        }
    }

    return stack.last()
}
