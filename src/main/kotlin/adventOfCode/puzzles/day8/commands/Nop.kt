package adventOfCode.puzzles.day8.commands

internal class Nop(
    private val value: Int
) : Command {
    override fun execute(iterationInspector: IterationInspector) {
        iterationInspector.nextCommandIndex++
        iterationInspector.commandLog = "nop $value"
        iterationInspector.steps++
    }
}