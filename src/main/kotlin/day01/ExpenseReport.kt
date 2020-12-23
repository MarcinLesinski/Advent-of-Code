package day01


class ExpenseReport
constructor(
    private val reportPositions: List<Int>) {
//    var report: MutableList<Int> = mutableListOf<Int>()

    fun get(index: Int): Int {
        return reportPositions[index]
    }
}