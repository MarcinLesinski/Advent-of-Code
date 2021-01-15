package adventOfCode.domain

abstract class Puzzle<out TAnswer>(
    protected val input: RawInput
) {
    abstract fun solve(): TAnswer
}