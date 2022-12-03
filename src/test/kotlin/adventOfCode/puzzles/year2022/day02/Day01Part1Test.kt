package adventOfCode.puzzles.year2022.day02

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Part1Test {

    private lateinit var puzzle: Day02Part1

    @BeforeAll
    fun beforeAll(){
        val data = DataReader.readRawData(2022, 2)
        puzzle = Day02Part1(data)
    }

    @Test
    fun example() {
        val actual = puzzle.solve()

        Assertions.assertEquals(13924, actual)
    }
}
