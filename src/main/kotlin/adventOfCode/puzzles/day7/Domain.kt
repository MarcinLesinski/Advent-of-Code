package adventOfCode.puzzles.day7

import adventOfCode.puzzles.day7.dataParser.FlatBag

class Bag(
    val color: Color,
    val content: Array<SlotsForBagType>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bag

        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }

    fun canContains(color: Color): Boolean{
        return content.any{ it.bag.color == color} || content.any{ it.bag.canContains(color) }
    }

    fun size(): Int {
        return content.sumBy { it.amount } + content.sumBy{ it.amount * it.bag.size()}
    }

}

data class SlotsForBagType(
    val amount: Int,
    val bag: Bag
)

data class Color(
    val shade: String,
    val color: String
)

//region List<Bag>
fun List<Bag>.containsColor(color: Color): Boolean = any { it.color == color }
fun List<Bag>.findByColor(color: Color): Bag = first { it.color == color }
fun List<Bag>.suitable(color: Color): List<Bag>{
    return filter{it.canContains(color)}
}
//endregion

fun MutableList<Bag>.addFlatBag(flatBag: FlatBag) {
    val color = flatBag.color
    val content = flatBag.content.map { SlotsForBagType(it.amount, findByColor(it.color)) }.toTypedArray()
    val bag = Bag(color, content)
    add(bag)
}
