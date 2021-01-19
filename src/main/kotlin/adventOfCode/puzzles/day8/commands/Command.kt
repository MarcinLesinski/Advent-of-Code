package adventOfCode.puzzles.day8.commands

interface Command {
    fun execute(iterationInspector: IterationInspector)
    val value: Int
}