package adventOfCode.puzzles.year2020.day5

import adventOfCode.puzzles.year2020.day5.common.SeatDecoder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SeatDecoderTest(){

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("0", "0", 0),
                Arguments.of("0", "1", 1),
                Arguments.of("0", "11", 3) ,
                Arguments.of("0", "111", 7),
                Arguments.of("1", "1", 9),
                Arguments.of("1", "111", 15)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun example(rows: String, columns: String, expected: Int) {
        val actual = SeatDecoder(rows.length, columns.length).decode(rows + columns)
        assertEquals(expected, actual)
    }
}
