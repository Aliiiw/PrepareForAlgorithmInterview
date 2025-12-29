package hacker_rank.array

/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val diff = LongArray(n + 2)

    for (q in queries) {
        val a = q[0]
        val b = q[1]
        val k = q[2].toLong()
        diff[a] += k
        diff[b + 1] -= k
    }

    println(diff.contentToString())

    var maxVal = 0L
    var running = 0L
    for (i in 1..n) {
        running += diff[i]
        if (running > maxVal) maxVal = running
    }

    return maxVal
}


fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}
