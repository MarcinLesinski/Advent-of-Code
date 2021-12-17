package adventOfCode.puzzles.year2021.day16

import adventOfCode.common.multiplyBy
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import java.math.BigInteger

@Year(2021)
@Day(16, 2)
internal class Day16Part2(input: RawInput) : Puzzle<BigInteger>(input) {

    override fun solve(): BigInteger {
        val mainPackage = Parser(input).parse()
        return mainPackage.calc()
    }

}
