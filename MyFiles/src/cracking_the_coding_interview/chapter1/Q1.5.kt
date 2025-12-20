package cracking_the_coding_interview.chapter1

/*
One Away: There are three types of edits that can be performed on strings:
insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

EXAMPLE
pale, pie -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
 */

fun main() {
    val test = "Tact Coa"
    print(oneEditAway2(test,"Tact Coaar"))

}

// v1
fun oneEditAway1(firstText: String, secondText: String): Boolean {
    if (firstText == secondText) return true

    val generated = HashSet<String>()

    for (index in firstText.indices) {
        generated.add(firstText.removeRange(index, index + 1))
    }

    for (index in 0..firstText.length) {
        for (characterCode in 'a'..'z') {
            val candidate = firstText.substring(0, index) + characterCode + firstText.substring(index)
            generated.add(candidate)
        }
    }

    for (index in firstText.indices) {
        for (characterCode in 'a'..'z') {
            val candidate = firstText.substring(0, index) + characterCode + firstText.substring(index + 1)
            generated.add(candidate)
        }
    }

    return secondText in generated
}

// v2
fun oneEditAway2(firstText: String, secondText: String): Boolean {
    val firstLength = firstText.length
    val secondLength = secondText.length

    if (kotlin.math.abs(firstLength - secondLength) > 1) return false
    if (firstText == secondText) return true

    val shorterText: String
    val longerText: String

    if (firstLength <= secondLength) {
        shorterText = firstText
        longerText = secondText
    } else {
        shorterText = secondText
        longerText = firstText
    }

    var shorterIndex = 0
    var longerIndex = 0
    var foundDifference = false

    while (shorterIndex < shorterText.length && longerIndex < longerText.length) {
        if (shorterText[shorterIndex] == longerText[longerIndex]) {
            shorterIndex++
            longerIndex++
        } else {
            if (foundDifference) return false
            foundDifference = true

            if (shorterText.length == longerText.length) {
                shorterIndex++
                longerIndex++
            } else {
                longerIndex++
            }
        }
    }

    return true
}
