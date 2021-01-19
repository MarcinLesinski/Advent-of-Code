package adventOfCode.puzzles.day8.loopDetector

class LoopDetector : (Int) -> DetectResult {
    private val executedCommandIndices: MutableSet<Int> = mutableSetOf()

    override fun invoke(index: Int): DetectResult {
        return if (executedCommandIndices.add(index))
            DetectResult.NOT_YET_DETECTED
        else
            DetectResult.DETECTED
    }
}

class LastItemDetector(private val lastIndex: Int) : (Int) -> DetectResult {
    private val loopDetector = LoopDetector()

    override fun invoke(index: Int): DetectResult {
        return if (index == lastIndex){
            DetectResult.DETECTED
        }else{
            when(loopDetector.invoke(index)){
                DetectResult.DETECTED -> DetectResult.FAILED
                DetectResult.NOT_YET_DETECTED -> DetectResult.NOT_YET_DETECTED
                else -> {DetectResult.NOT_YET_DETECTED}
            }
        }
    }
}

enum class DetectResult {
    DETECTED, NOT_YET_DETECTED, FAILED
}