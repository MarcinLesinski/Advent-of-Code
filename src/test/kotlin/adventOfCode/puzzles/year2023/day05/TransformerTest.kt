package adventOfCode.puzzles.year2023.day05

import org.junit.jupiter.api.Test

class TransformerTest{

    @Test
    fun `should map one range`(){
        val transformer = Transformer("", "", listOf(
            DomainRange(50, 100, 10)
        ))

        val input = InputBasedOnRanges("", listOf(
            InputRange(100, 110)
        ))

        val result = transformer.transform(input)

        assert(result.ranges.size == 1 )
    }

    @Test
    fun `should return 3 ranges when input is wider`(){
        val transformer = Transformer("", "", listOf(
            DomainRange(50, 100, 10)
        ))

        val input = InputBasedOnRanges("", listOf(
            InputRange(90, 120)
        ))

        val result = transformer.transform(input)

        assert(result.ranges.size == 3)
    }

    @Test
    fun `should return range when does not fit`(){
        val transformer = Transformer("", "", listOf(
            DomainRange(50, 100, 10)
        ))

        val input = InputBasedOnRanges("", listOf(
            InputRange(200, 250)
        ))

        val result = transformer.transform(input)

        assert(result.ranges.isEmpty())
    }



    @Test
    fun `should map two ranges`(){
        val transformer = Transformer("", "", listOf(
//            Range(50, 100, 10),
            DomainRange(150, 200, 10),
        ))

        val input = InputBasedOnRanges("", listOf(
            InputRange(90, 120)
        ))

        val result = transformer.transform(input)

        println(result)
    }

}
