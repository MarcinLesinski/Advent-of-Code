package adventOdCode.puzzles.day02

data class Occurrence(
    val atLeast: Int,
    val atMost: Int)

data class PasswordRule(
    val character: Char,
    val occurrence: Occurrence,
    val password: String)
