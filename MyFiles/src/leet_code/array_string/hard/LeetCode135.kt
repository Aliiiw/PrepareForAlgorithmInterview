package leet_code.array_string.hard


fun main() {
    print(candy(intArrayOf(1, 0, 2)))
}

fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val candies = IntArray(n) { 1 }

    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }
    }

    var sum = 0
    for (c in candies) sum += c
    return sum
}

