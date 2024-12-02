package adventOfCode.common.typeExtentions

import adventOfCode.domain.split
import adventOfCode.domain.splitBy

/**
 * it converts numbers separated by spaces in string format to list of numbers
 * example: text = "1 2 3 4 5"
 * text.asNumbers() -> [1, 2, 3, 4 ,5]
 */
fun List<String>.asLinesOfNumbers(): List<List<Int>> {
    return this.map{
        line -> line.split(Regex("\\s+")).map{it.toInt()}
    }
}