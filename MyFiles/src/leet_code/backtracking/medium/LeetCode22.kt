package leet_code.backtracking.medium


/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 */


fun main() {
    print(
        generateParenthesis(5)
    )
}

fun generateParenthesis(n: Int): List<String> {
    val res = ArrayList<String>()
    val sb = StringBuilder()

    fun dfs(open: Int, close: Int) {
        if (sb.length == 2 * n) {
            res.add(sb.toString())
            return
        }

        if (open < n) {
            sb.append('(')
            dfs(open + 1, close)
            sb.deleteCharAt(sb.length - 1)
        }

        if (close < open) {
            sb.append(')')
            dfs(open, close + 1)
            sb.deleteCharAt(sb.length - 1)
        }
    }

    dfs(0, 0)
    return res
}

fun generateParenthesis2(n: Int): List<String> {
    val res = ArrayList<String>()
    val path = CharArray(2 * n)

    fun dfs(idx: Int, open: Int, close: Int) {
        if (idx == 2 * n) {
            res.add(String(path))
            return
        }

        if (open < n) {
            path[idx] = '('
            dfs(idx + 1, open + 1, close)
        }

        if (close < open) {
            path[idx] = ')'
            dfs(idx + 1, open, close + 1)
        }
    }

    dfs(0, 0, 0)
    return res
}
