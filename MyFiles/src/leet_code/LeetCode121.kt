package leet_code


fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    print(maxProfit2(prices))

}

// v1
fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var best = 0

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else {
            val profit = price - minPrice
            if (profit > best) best = profit
        }
    }
    return best
}

// v2
fun maxProfit2(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var left = 0
    var right = 1
    var best = 0

    while (right < prices.size) {
        if (prices[right] > prices[left]) {
            val profit = prices[right] - prices[left]
            if (profit > best) best = profit
        } else {
            left = right
        }
        right++
    }
    return best
}




