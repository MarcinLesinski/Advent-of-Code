package adventOdCode.puzzles


import adventOdCode.common.DataReader
import adventOdCode.common.Matrix
import adventOdCode.domain.BitMask
import adventOdCode.domain.asBitMask
import adventOdCode.puzzles.day02.part2.InputParser
import adventOdCode.puzzles.day3.Ride
import adventOdCode.puzzles.day3.Slope
import adventOdCode.puzzles.day3.Trail

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Day03Part1Test {

    lateinit var slope: Slope

    @BeforeAll
    fun beforeAll(){
        val input: BitMask = DataReader.readData(3).asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }
        slope = Slope(matrix)
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun examples(ride: Ride, expected: Int){
        val actual = Trail(slope, ride).obstacles()
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments>{
            return Stream.of(
                Arguments.of(Ride(1, 1), 2),
                Arguments.of(Ride(3, 1), 7),
                Arguments.of(Ride(5, 1), 3),
                Arguments.of(Ride(7, 1), 4),
                Arguments.of(Ride(1, 2), 2)
            )
        }
    }

}