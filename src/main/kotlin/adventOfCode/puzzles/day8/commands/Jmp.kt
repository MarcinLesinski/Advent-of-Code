package adventOfCode.puzzles.day8.commands

internal class Jmp(
    override val value: Int
): Command {
    override fun execute(iterationInspector: IterationInspector){
        iterationInspector.nextCommandIndex += value
        iterationInspector.commandLog = "jmp $value"
        iterationInspector.steps++

    }
}