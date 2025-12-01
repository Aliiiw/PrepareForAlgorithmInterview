fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
}

fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0

    val dp = IntArray(amount + 1) { amount + 1 }

    dp[0] = 0

    (1..amount).forEach { index ->
        for (coin in coins) {
            if (coin <= index) {
                dp[index] = minOf(dp[index], dp[index - coin] + 1)
            }
        }
    }
    return if (dp[amount] > amount) -1 else dp[amount]
}
