package adventOfCode.puzzles.day7.dataParser

import adventOfCode.domain.Lines
import adventOfCode.puzzles.day7.Color

internal class FlatModelParser {

    private val mainBoxIsBeforeSeparator = "bags contain"
    private val mainBoxContentSeparator = ","
    private val notContainBoxes = "no other"
    private val endOfDataLineChar = "."

    fun read(lines: Lines): Array<FlatBag> {
        return lines.map(this::parseLine).toTypedArray()
    }

    internal fun parseLine(line: String): FlatBag {
        val dataParts = line.split(mainBoxIsBeforeSeparator, mainBoxContentSeparator)
        val color = parseColor(dataParts[0])
        val content: MutableList<FlatSlotsForBagType> = mutableListOf()
        if (!line.contains(notContainBoxes))
            for (i in 1 until dataParts.size) {
                content.add(parseSlots((dataParts[i])))
            }

        return FlatBag(color, content.toTypedArray())
    }

    private fun parseColor(colorDefinition: String): Color {
        val (shade, color) = colorDefinition.trim().split(" ")
        return Color(shade, color)
    }

    private fun parseSlots(slotsDefinition: String): FlatSlotsForBagType {
        val parts = slotsDefinition.trim().split(" ")
        val (amountAsString, shade, color) = parts

        return FlatSlotsForBagType(amountAsString.toInt(), Color(shade, color))
    }
}

