package adventOfCode.puzzles.year2023.day05

import adventOfCode.domain.RawInput

val seeds =
    "4043382508 113348245 3817519559 177922221 3613573568 7600537 773371046 400582097 2054637767 162982133 2246524522 153824596 1662955672 121419555 2473628355 846370595 1830497666 190544464 230006436 483872831"
//    "79 14 55 13"
class Read {
    companion object {

        fun transformers(input: RawInput): List<Transformer> {
            return input.split("${System.lineSeparator()}${System.lineSeparator()}").map { block ->
                val lines = block.split("\n")
                val (from, to) = getNames(lines[0])
                val ranges = getSets(lines.drop(1))
                Transformer(from, to, ranges)
            }
        }

        fun input(line: String): Input {
            return Input(
                "seed",
                line.split(" ").map(String::toLong)
            )
        }

        fun inputRange(line: String): Input {
            val ranges = line.split(" ").map(String::toLong).windowed(2, 2) {
                val from = it[0]
                val to = from + it[1]
                (from.. to).toList()
            }.flatten()

            return Input(
                "seed",
                ranges
            )

        }

        fun inputAsRanges(line: String): InputBasedOnRanges {
                val ranges = line.split(" ").map(String::toLong).windowed(2, 2) {
                    val from = it[0]
                    val to = from + it[1]
                    InputRange(from, to)
                }

                return InputBasedOnRanges(
                    "seed",
                        ranges
                )
        }


        private fun getNames(line: String): Pair<From, To> {
            val `from to` = line
                .split(" ")[0]
                .split("-")
                .filterIndexed { index, _ ->
                    listOf(0, 2).contains(index)
                }
            return `from to`[0] to `from to`[1]
        }

        private fun getSets(lines: List<String>): List<DomainRange> {
            return lines
                .map { line ->
                    try {
                        val numbersAsText = line.trim().split(" ")
                        numbersAsText.map(String::toLong)
                    } catch (e: Error) {
                        println(e.message)
                        listOf(1L)
                    }
                }
                .map {
                    DomainRange(it[0], it[1], it[2])
                }
        }


    }
}
