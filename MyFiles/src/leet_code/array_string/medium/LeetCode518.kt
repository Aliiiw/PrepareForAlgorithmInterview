package leet_code.array_string.medium


fun main() {
    print(change(5, intArrayOf(1, 2, 5)))
}


fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1)
    dp[0] = 1

    for (coin in coins) {
        for (x in coin..amount) {
            dp[x] += dp[x - coin]
        }
    }

    return dp[amount]
}

