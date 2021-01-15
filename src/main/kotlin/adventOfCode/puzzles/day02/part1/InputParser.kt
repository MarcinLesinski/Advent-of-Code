package adventOfCode.puzzles.day02.part1

class InputParser {
    companion object  {
        fun parse(line: String): PasswordRule {
            val parts = line.split("-", " ", ": ")

            val occursAtLeast = parts[0].toInt()
            val occursAtMost = parts[1].toInt()
            val character = parts[2].single()
            val password = parts[3]

            val occurrence = Occurrence(occursAtLeast, occursAtMost)
            return PasswordRule(character, occurrence, password)
        }
    }
}