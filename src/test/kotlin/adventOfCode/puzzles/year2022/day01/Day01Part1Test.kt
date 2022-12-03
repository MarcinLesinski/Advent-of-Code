package adventOfCode.puzzles.year2022.day01

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Part1Test {

    private lateinit var puzzle: Day01Part1

    @BeforeAll
    fun beforeAll(){
        val data = DataReader.readRawData(2022, 1)
        puzzle = Day01Part1(data)
    }

    @Test
    fun example() {
        val actual = puzzle.solve()

        Assertions.assertEquals(65912, actual)
    }
}
