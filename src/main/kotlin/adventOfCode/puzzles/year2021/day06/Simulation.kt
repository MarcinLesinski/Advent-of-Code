package adventOfCode.puzzles.year2021.day06

class Simulation(ages: List<Pair<Long, Long>>){
    private var map = mutableMapOf(*ages.toTypedArray())
    init{
        (0..8L).forEach {
            if(map.contains(it).not())
                map[it] = 0
        }
    }

    fun step() {
        val newMap = mutableMapOf<Long, Long>()
        for (i in 1..8L) {
            newMap[i - 1L] = map[i]!!
        }

        newMap[8] = map[0]!! //births
        newMap[6] = newMap[6]!! + map[0]!! //reset
        this.map = newMap
    }

    fun fishCount(): Long {
        return map.values.sum()
    }
}
