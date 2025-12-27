package leet_code.dp_multidimensional.hard


/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve.
You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously
(i.e., you must sell the stock before you buy again).
 */


fun main() {
    print(
        maxProfit(
            intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
        )
    )
}

fun maxProfit(prices: IntArray): Int {
    val n = prices.size
    if (n == 0) return 0

    val k = 2
    val dp = Array(k + 1) { IntArray(n) }

    for (t in 1..k) {
        var best = -prices[0]
        for (i in 1 until n) {
            dp[t][i] = maxOf(dp[t][i - 1], prices[i] + best)
            best = maxOf(best, dp[t - 1][i] - prices[i])
        }
    }

    return dp[k][n - 1]
}


fun maxProfit2(prices: IntArray): Int {
    val n = prices.size
    if (n == 0) return 0

    val left = IntArray(n)
    var minPrice = prices[0]
    for (i in 1 until n) {
        minPrice = minOf(minPrice, prices[i])
        left[i] = maxOf(left[i - 1], prices[i] - minPrice)
    }

    val right = IntArray(n)
    var maxPrice = prices[n - 1]
    for (i in n - 2 downTo 0) {
        maxPrice = maxOf(maxPrice, prices[i])
        right[i] = maxOf(right[i + 1], maxPrice - prices[i])
    }

    var ans = 0
    for (i in 0 until n) {
        ans = maxOf(ans, left[i] + right[i])
    }
    return ans
}


