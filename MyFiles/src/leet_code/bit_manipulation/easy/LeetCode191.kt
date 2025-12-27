package leet_code.bit_manipulation.easy


/**
Given a positive integer n, write a function that returns the number of
set bits in its binary representation (also known as the Hamming weight).
 */


fun main() {
    print(hammingWeight(128))
}


fun hammingWeight(n: Int): Int {
    var x = n
    var counter = 0

    while (x != 0) {
        x = x and (x - 1)
        counter++
    }

    return counter
}

