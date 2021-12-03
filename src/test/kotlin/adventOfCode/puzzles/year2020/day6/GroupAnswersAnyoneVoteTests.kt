package adventOfCode.puzzles.year2020.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GroupAnswersAnyoneVoteTests {

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("abc"), 3),
                Arguments.of(listOf("a", "b", "c"), 3),
                Arguments.of(listOf("ab", "ac"), 3),
                Arguments.of(listOf("a", "a", "a", "a"), 1),
                Arguments.of(listOf("b"), 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun `count question to which anyone answered yes`(input: List<String>, expected: Int) {

        val actual = countAnswersWithAtLeastOneVote(input)

        assertEquals(expected, actual)
    }

}
