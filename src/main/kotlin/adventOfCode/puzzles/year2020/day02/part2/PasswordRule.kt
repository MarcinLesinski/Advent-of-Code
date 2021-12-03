package adventOfCode.puzzles.year2020.day02.part2

typealias Positions = Array<Int>

data class PasswordRule(
    val character: Char,
    val occurrences: Positions,
    val password: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PasswordRule

        if (character != other.character) return false
        if (!occurrences.contentEquals(other.occurrences)) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = character.hashCode()
        result = 31 * result + occurrences.contentHashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}
