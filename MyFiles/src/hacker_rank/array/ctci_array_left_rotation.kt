package hacker_rank.array

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */


fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val n = a.size
    val k = d % n
    val result = Array(n) { 0 }

    for (i in 0 until n) {
        result[i] = a[(i + k) % n]
    }

    return result
}


fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
