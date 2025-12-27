package leet_code.dp.easy


/**
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?
 */


fun main() {
    print(climbStairs(4))
}

fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

fun climbStairs2(n: Int): Int {
    if (n <= 2) return n

    var a = 1
    var b = 2

    var i = 3
    while (i <= n) {
        val c = a + b
        a = b
        b = c
        i++
    }

    return b
}

