package adventOfCode.common.typeExtentions

val Int.even : Boolean
    get() = (this.rem(2) == 0) && (this != 0)

val Int.odd: Boolean
    get() = this.even.not() && (this != 0)
