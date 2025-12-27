package leet_code.dp_multidimensional.hard


/**
You are given an integer array prices where prices[i]
is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions:
i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously
(i.e., you must sell the stock before you buy again).
 */


fun main() {
    print(
        maxProfit(
            2,
            intArrayOf(2, 4, 1)
        )
    )
}

fun maxProfit(k: Int, prices: IntArray): Int {
    val n = prices.size
    if (n < 2 || k == 0) return 0

    if (k >= n / 2) {
        var profit = 0
        for (i in 1 until n) {
            val diff = prices[i] - prices[i - 1]
            if (diff > 0) profit += diff
        }
        return profit
    }

    var prev = IntArray(n)
    var cur = IntArray(n)

    for (t in 1..k) {
        var best = prev[0] - prices[0]
        cur[0] = 0

        for (i in 1 until n) {
            cur[i] = maxOf(cur[i - 1], prices[i] + best)
            best = maxOf(best, prev[i] - prices[i])
        }

        val tmp = prev
        prev = cur
        cur = tmp
    }

    return prev[n - 1]
}
