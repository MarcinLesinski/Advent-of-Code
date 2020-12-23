package day01

data class Result(
    var firstIndex: Int? = null,
    var firstValue: Int? = null,
    var secondIndex: Int? = null,
    var secondValue: Int? = null
)

data class DataEntry(val index: Int, val value: Int)
data class PairOfDataEntries(val left: DataEntry, val right: DataEntry)

class FindItemsThatSumsTo2020Algorithm {
    private val algorithmTargetValue = 2020

    fun process(data: List<Int>): PairOfDataEntries {
        val pairs = pairs(data);
        val first: PairOfDataEntries = pairs.first { it.left.value + it.right.value == algorithmTargetValue }
        return first
    }

    private fun pairs(data: List<Int>) = data.mapIndexed{ index: Int, value: Int ->  preparePairsFor(data, DataEntry(index, value)) }.flatten()

    private fun preparePairsFor(data: List<Int>, dataEntry: DataEntry): List<PairOfDataEntries>{
        val currentIndex = dataEntry.index

        return data
            .takeLast(data.size - (currentIndex + 1))
            .mapIndexed{index, value -> PairOfDataEntries(dataEntry, DataEntry(currentIndex + index + 1, value)) }.toList()
    }
}
