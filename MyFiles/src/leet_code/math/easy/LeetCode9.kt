package leet_code.math.easy


/**
Given an integer x, return true if x is a palindrome, and false otherwise.
 */


fun main() {
    print(isPalindrome(121))
}


fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    var num = x
    var reversed = 0

    while (num > reversed) {
        reversed = reversed * 10 + num % 10
        num /= 10
    }

    return num == reversed || num == reversed / 10
}

fun isPalindrome2(x: Int): Boolean {
    if (x < 0) return false

    var num = x
    var rev = 0

    while (num > 0) {
        rev = rev * 10 + num % 10
        num /= 10
    }

    return rev == x
}
