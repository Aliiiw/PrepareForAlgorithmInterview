package cracking_the_coding_interview.chapter1

/*
Check Permutation:
Given two strings, write a method to decide if one is a permutation of the other.
 */

fun main() {
    print(arePermutations1("abc", "bca"))
}

// v1
fun arePermutations1(firstText: String, secondText: String): Boolean {
    if (firstText.length != secondText.length) return false

    val firstCharacters = firstText.toCharArray()
    val secondCharacters = secondText.toCharArray()

    firstCharacters.sort()
    secondCharacters.sort()

    return firstCharacters.contentEquals(secondCharacters)
}

