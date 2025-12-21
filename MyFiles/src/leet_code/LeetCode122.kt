package leet_code

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    print(maxProfitII(prices))
}

fun maxProfitII(prices: IntArray): Int {
    var profit = 0
    for (i in 1 until prices.size) {
        val different = prices[i] - prices[i - 1]
        if (different > 0) profit += different
    }
    return profit
}



