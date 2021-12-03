package adventOfCode.puzzles.year2020.day8.commands

interface Command {
    fun execute(iterationInspector: IterationInspector)
    val value: Int
}
