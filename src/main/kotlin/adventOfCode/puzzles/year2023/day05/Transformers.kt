package adventOfCode.puzzles.year2023.day05

class Transformers(
    private val transformers: List<Transformer>
) {
    fun get(input: Input): Transformer {
        return transformers.first {
            it.from == input.kind
        }
    }

    fun get(input: InputBasedOnRanges): Transformer {
        return transformers.first {
            it.from == input.kind
        }
    }

}
