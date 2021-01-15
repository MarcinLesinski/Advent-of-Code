package adventOfCode.common

fun <T>List<T>.multiplyBy( factor: (T) -> Long  ): Long{
    var result = 1L
    for (item in this){
        result *= factor(item)
    }
    return result
}

fun <T>Array<T>.multiplyBy( factor: (T) -> Long  ): Long{
    var result = 1L
    for (item in this){
        result *= factor(item)
    }
    return result
}
