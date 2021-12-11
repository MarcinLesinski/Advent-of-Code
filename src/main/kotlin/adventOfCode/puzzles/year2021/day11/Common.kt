package adventOfCode.puzzles.year2021.day11

import adventOfCode.common.Matrix

class Shroom(var energy: Int, private val row: Int, private val col: Int, private val explosionsCounter: ()->Unit) {

    private lateinit var shrooms: Matrix<Shroom>
    var detonated = false
    fun addShrooms(shrooms: Matrix<Shroom>) {
        this.shrooms = shrooms
    }

    private fun onSomeExplode(row: Int, col: Int) {
        var neighbor = ((row in arrayOf(this.row + 1, this.row, this.row - 1)) && (col in arrayOf(this.col + 1, this.col, this.col - 1)))
        neighbor = neighbor && !(col == this.col && row==this.row)
        if (neighbor)
            incEnergy()
    }

    fun claim() {
        if (energy > 9) {
            energy = 0
            detonated = false
        }
    }

    fun passiveIncEnergy(){
        energy += 1
    }

    fun symulate() {
        if ((energy > 9) && detonated.not() ) {
            detonated = true
            explosionsCounter()
            shrooms.forEachField {
                it.onSomeExplode(row, col)
            }
        }
    }

    private fun incEnergy() {
        passiveIncEnergy()
        symulate()
    }
}

class ShroomsFactory(private val data: Matrix<Int>, private val explosionsCounter: ()->Unit) {
    fun construct(): Matrix<Shroom> {
        val shrooms = data.mapWithCoords{ data, col, row ->
            Shroom(data, col, row, explosionsCounter)
        }
        shrooms.forEachField {
            it.addShrooms(shrooms)
        }
        return shrooms
    }
}
