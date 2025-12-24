package leet_code.math.easy

fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    var sum = ""

    while (i >= 0 || j >= 0 || carry == 1) {
        if (i >= 0) {
            carry += a[i].toString().toInt()
            i--
        }
        if (j >= 0) {
            carry += b[j].toString().toInt()
            j--
        }
        sum = (carry % 2).toString() + sum
        carry /= 2
    }
    return sum
}