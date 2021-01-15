package adventOfCode.puzzles.day4

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
            .split("\r\n\r\n")

        val singleLineBundles: List<String> = rawBundles
            .map { it.replace("\r\n", " ") }

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
}