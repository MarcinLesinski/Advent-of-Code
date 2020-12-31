package adventOdCode.puzzles.day02.part2

class InputParser {
    companion object  {
        fun parse(line: String): PasswordRule {
            val parts = line.split("-", " ", ": ")

            val positions = arrayOf(parts[0].toInt(), parts[1].toInt())
            val character = parts[2].single()
            val password = parts[3]


            return PasswordRule(character, positions, password)
        }
    }
}