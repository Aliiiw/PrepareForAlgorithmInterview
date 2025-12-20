package cracking_the_coding_interview.chapter1

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note:
If implementing in Java, please use a character array so that you can perform this operation in place.)
 */

fun main() {

    val inputCharacters = "Mr John Smith    "
    val resultCharacters = urlify2(inputCharacters, 13)
    println(resultCharacters)
}

// v1
fun urlify1(text: String, trueLength: Int): String {
    return text.substring(0, trueLength).replace(" ", "%20")
}

// v2
fun urlify2(text: String, trueLength: Int): String {
    val result = StringBuilder()

    for (index in 0 until trueLength) {
        val currentCharacter = text[index]

        if (currentCharacter == ' ') result.append("%20")
        else result.append(currentCharacter)

    }

    return result.toString()
}
