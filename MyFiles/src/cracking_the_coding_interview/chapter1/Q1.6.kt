package cracking_the_coding_interview.chapter1

/*
String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 For example, the string aabcccccaaa would become a2b1c5a3, If the "compressed" string would not become smaller than the original string,
  your method should return the original string.
 You can assume the string has only uppercase and lowercase letters (a - z).
 */

fun main() {
    val test = "aabcccccaaa"
    print(stringCompression(test))
}

// v1
fun stringCompression(input: String): String {
    val result = StringBuilder()

    var currentCharacter = input[0]
    var currentNumberOfOccurs = 1

    for (index in 1 until input.length) {
        val nextCharacter = input[index]

        if (currentCharacter == nextCharacter) {
            currentNumberOfOccurs++
        } else {
            result.append(currentCharacter)
            result.append(currentNumberOfOccurs)
            currentCharacter = nextCharacter
            currentNumberOfOccurs = 1
        }
    }

    result.append(currentCharacter)
    result.append(currentNumberOfOccurs)

    val compressedText = result.toString()
    return if (compressedText.length < input.length) compressedText else input
}

