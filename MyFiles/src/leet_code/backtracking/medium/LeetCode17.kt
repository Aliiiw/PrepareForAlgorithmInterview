package leet_code.backtracking.medium

import kotlin.math.abs


/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent.
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
 */


fun main() {
    print(
        letterCombinations("29")
    )
}


fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val map = arrayOf(
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    val res = ArrayList<String>()
    val path = StringBuilder()

    fun dfs(index: Int) {
        if (index == digits.length) {
            res.add(path.toString())
            return
        }

        val letters = map[digits[index] - '0']
        for (ch in letters) {
            path.append(ch)
            dfs(index + 1)
            path.deleteCharAt(path.length - 1)
        }
    }

    dfs(0)
    return res
}

