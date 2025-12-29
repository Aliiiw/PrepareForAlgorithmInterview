package hacker_rank.warm_up

import kotlin.text.iterator

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    var altitude = 0
    var valleys = 0

    for (character in path) {
        val prev = altitude
        if (character == 'U') altitude++ else altitude--
        if (prev < 0 && altitude == 0) valleys++
    }

    return valleys
}


fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
