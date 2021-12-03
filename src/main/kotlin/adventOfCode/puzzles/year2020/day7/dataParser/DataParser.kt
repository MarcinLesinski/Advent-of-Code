package adventOfCode.puzzles.year2020.day7.dataParser

import adventOfCode.domain.Lines
import adventOfCode.puzzles.year2020.day7.Bag
import adventOfCode.puzzles.year2020.day7.addFlatBag
import adventOfCode.puzzles.year2020.day7.containsColor

class DataParser {
    fun parse(lines: Lines): List<Bag> {
        val flatBags = FlatModelParser().read(lines)
        val bags: MutableList<Bag> = mutableListOf()

        var iteration = 0
        do {
            iteration++
            var atLeastOneBagWasAddedInLastIteration = false
            flatBags.forEach {
                if (!bags.containsColor(it.color) && isBagPossibleToCreate(it, bags)) {
                    bags.addFlatBag(it)
                    atLeastOneBagWasAddedInLastIteration = true
                }
            }
        } while(atLeastOneBagWasAddedInLastIteration)

        return bags
    }

    private fun isBagPossibleToCreate(flatBag: FlatBag, addedBags: List<Bag>): Boolean {
        return flatBag
            .content
            .map { it.color }
            .all(addedBags::containsColor)
    }

}
