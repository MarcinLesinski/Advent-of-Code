package adventOfCode.puzzles.year2020.day8.commands

internal class Jmp(
    override val value: Int
): Command {
    override fun execute(iterationInspector: IterationInspector){
        iterationInspector.nextCommandIndex += value
        iterationInspector.commandLog = "jmp $value"
        iterationInspector.steps++

    }
}
