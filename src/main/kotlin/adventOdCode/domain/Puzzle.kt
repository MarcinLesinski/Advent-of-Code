package adventOdCode.domain

abstract class Puzzle<TInput, out TAnswer>(
    protected val input: TInput
) {
    abstract fun solve(): TAnswer
}