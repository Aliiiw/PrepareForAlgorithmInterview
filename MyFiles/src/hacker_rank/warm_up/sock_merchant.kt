package hacker_rank.warm_up

/**
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val map = HashMap<Int, Int>()
    for (number in ar) map[number] = (map[number] ?: 0) + 1

    var pairs = 0
    for (value in map.values) pairs += value / 2
    return pairs
}


fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
