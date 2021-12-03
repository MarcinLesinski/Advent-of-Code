package adventOfCode.puzzles.year2020.day7.dataParser

import adventOfCode.puzzles.year2020.day7.Color

class FlatBag(
    val color: Color,
    val content: Array<FlatSlotsForBagType>
){
    override fun toString(): String {
        return "FlatBag(color=$color, content=${content.contentToString()})"
    }
}

class FlatSlotsForBagType(
    val amount: Int,
    val color: Color
)
