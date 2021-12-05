package adventOfCode.puzzles.year2020.day4

typealias Bundle = List<Pair<String, String>>
typealias Bundles = List<Bundle>

class PassportsReader {

    fun read(input: String): List<Passport>? {
        val bundles = prepareBundles(input)
        return bundles.map{ PassportBuilder.build(it) }
    }

    fun readSimple(input: String): List<SimplePassport>?{
        val bundles = prepareBundles(input)
        return bundles.map{ SimplePassportBuilder.build(it) }
    }

    private fun prepareBundles(input: String): Bundles{
        val rawBundles: List<String> = input
            .split(newLine(2))

        val singleLineBundles: List<String> = rawBundles
            .map { it.replace(newLine(), " ") }

        val bundlesOfLines: List<List<String>> = singleLineBundles
            .map { it.split(" ") }

        val bundlesOfPairs: List<List<Pair<String, String>>> = bundlesOfLines.map {
            it.map {
                val entry = it.split(":")
                Pair(entry[0], entry[1])
            }
        }

        return bundlesOfPairs
    }

    private fun newLine(count: Int = 1): String = System.lineSeparator().repeat(count)
}
