package adventOfCode.puzzles.day7

import adventOfCode.puzzles.day7.dataParser.FlatModelParser
import adventOfCode.puzzles.day7.dataParser.FlatBag
import adventOfCode.puzzles.day7.dataParser.FlatSlotsForBagType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class InputDataParseTests {

    @ParameterizedTest
    @MethodSource("inputsSource")
    internal fun `parse main box color`(dataLine: String, expected: FlatBag) {
        val actual = FlatModelParser().parseLine(dataLine)

        Assertions.assertEquals(expected.color, actual.color)
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    internal fun `parse count of content types`(dataLine: String, expected: FlatBag) {
        val actual = FlatModelParser().parseLine(dataLine)

        Assertions.assertEquals(expected.content.size, actual.content.size)
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    internal fun `parse amounts of content`(dataLine: String, expected: FlatBag) {
        val actual = FlatModelParser().parseLine(dataLine)

        val actualAmounts = actual.content.map { it.amount }
        val expectedAmounts = expected.content.map { it.amount }

        Assertions.assertEquals(expectedAmounts, actualAmounts)
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    internal fun `parse colors of content`(dataLine: String, expected: FlatBag) {
        val actual = FlatModelParser().parseLine(dataLine)

        for (i in actual.content.indices)
            Assertions.assertEquals(
                expected.content[i].color,
                actual.content[i].color
            )
    }


    companion object {
        private const val `bright black bags contain 1 dark maroon bag` =
            "bright black bags contain 1 dark maroon bag."
        private const val `dark gray bags contain no other bags` =
            "dark gray bags contain no other bags."
        private const val `pale gray bags contain 2 striped orange bags, 1 plaid green bag, 2 faded orange bags, 3 mirrored blue bags` =
            "pale gray bags contain 2 striped orange bags, 1 plaid green bag, 2 faded orange bags, 3 mirrored blue bags."

        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    `bright black bags contain 1 dark maroon bag`,
                    FlatBag(
                        Color("bright", "black"),
                        arrayOf(
                            FlatSlotsForBagType(1, Color("dark", "maroon"))
                        )
                    )
                ),
                Arguments.of(
                    `dark gray bags contain no other bags`,
                    FlatBag(
                        Color("dark", "gray"),
                        arrayOf()
                    )
                ),
                Arguments.of(
                    `pale gray bags contain 2 striped orange bags, 1 plaid green bag, 2 faded orange bags, 3 mirrored blue bags`,
                    FlatBag(
                        Color("pale", "gray"),
                        arrayOf(
                            FlatSlotsForBagType(2, Color("striped", "orange")),
                            FlatSlotsForBagType(1, Color("plaid", "green")),
                            FlatSlotsForBagType(2, Color("faded", "orange")),
                            FlatSlotsForBagType(3, Color("mirrored", "blue"))
                        )
                    )
                )
            )
        }
    }

}