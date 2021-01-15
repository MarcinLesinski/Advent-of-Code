package adventOfCode.puzzles.day5.common

fun parseInput(input: String): String{
    val result = input
        .replace(Regex("[BR]"), "1")
        .replace(Regex("[FL]"), "0")

    check(result.all{ it in setOf('0', '1') }) { "wrong input: $result" }
    return result
}