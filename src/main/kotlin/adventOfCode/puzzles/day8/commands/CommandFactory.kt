package adventOfCode.puzzles.day8.commands

fun constructCommand(commandDefinition: String): Command {
    val (command, valueAsString) = commandDefinition.trim().split(" ")
    val value = valueAsString.toInt()
    return when(command){
        "jmp" -> Jmp(value)
        "acc" -> Acc(value)
        "nop" -> Nop(value)
        else -> error("command: $command is unknown")
    }
}