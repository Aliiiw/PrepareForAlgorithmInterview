package leet_code.bit_manipulation.easy


/**
Reverse bits of a given 32 bits signed integer.
 */


fun main() {
    print(reverseBits(43261596))
}


fun reverseBits(n: Int): Int {
    var x = n
    var res = 0
    var i = 0

    while (i < 32) {
        res = (res shl 1) or (x and 1)
        x = x ushr 1
        i++
    }

    return res
}
