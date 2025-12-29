package hacker_rank.warm_up

/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */

fun jumpingOnClouds(c: Array<Int>): Int {
    var i = 0
    var jumpCounter = 0

    while (i < c.size - 1) {
        if (i + 2 < c.size && c[i + 2] == 0) i += 2 else i++
        jumpCounter++
    }

    return jumpCounter
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
