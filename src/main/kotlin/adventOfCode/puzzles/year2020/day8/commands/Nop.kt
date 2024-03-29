package adventOfCode.puzzles.year2020.day8.commands

internal class Nop(
    override val value: Int
) : Command {
    override fun execute(iterationInspector: IterationInspector) {
        iterationInspector.nextCommandIndex++
        iterationInspector.commandLog = "nop $value"
        iterationInspector.steps++
    }
}
