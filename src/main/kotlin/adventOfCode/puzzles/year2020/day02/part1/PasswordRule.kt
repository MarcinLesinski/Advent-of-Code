package adventOfCode.puzzles.year2020.day02.part1

data class Occurrence(
    val atLeast: Int,
    val atMost: Int)

data class PasswordRule(
    val character: Char,
    val occurrence: Occurrence,
    val password: String)
