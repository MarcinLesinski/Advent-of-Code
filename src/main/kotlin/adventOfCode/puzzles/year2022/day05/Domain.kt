package adventOfCode.puzzles.year2022.day05


class Move(val count: Int, val from: Int, val to: Int ) {
    override fun toString(): String {
        return "$count $from $to"
    }
}

/**
        [S] [C]         [Z]
    [F] [J] [P]         [T]     [N]
    [G] [H] [G] [Q]     [G]     [D]
    [V] [V] [D] [G] [F] [D]     [V]
    [R] [B] [F] [N] [N] [Q] [L] [S]
    [J] [M] [M] [P] [H] [V] [B] [B] [D]
    [L] [P] [H] [D] [L] [F] [D] [J] [L]
    [D] [T] [V] [M] [J] [N] [F] [M] [G]
    1   2   3   4   5   6   7   8   9

 */
fun stacks(): MutableMap<Int, String> {
    val map = mutableMapOf<Int, String>()
    map[1] = "DLJRVGF"
    map[2] = "TPMBVHJS"
    map[3] = "VHMFDGPC"
    map[4] = "MDPNGQ"
    map[5] = "JLHNF"
    map[6] = "NFVQDGTZ"
    map[7] = "FDBL"
    map[8] = "MJBSVDN"
    map[9] = "GLD"
    return map
}
